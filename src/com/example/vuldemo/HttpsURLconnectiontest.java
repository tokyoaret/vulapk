package com.example.vuldemo;

import android.app.Activity;
import android.os.Bundle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import android.os.AsyncTask;
import android.widget.TextView;

import org.apache.commons.io.IOUtils;


public class HttpsURLconnectiontest extends Activity {
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_http_urlconnection);
		this.textView = (TextView) findViewById(R.id.httptext);
		

        // 接続先のURLを指定してHTTP GET実行
        URL url = null;
        try {
            url = new URL("https://line.me/ja");
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        new HttpGetTask().execute(url);
	}
	
	// AsyncTaskのサブクラスとして、バックグラウンドでHTTP GETしてTextViewに表示するタスクを定義
    class HttpGetTask extends AsyncTask<URL, Void, String> {
        // HttpURLConnectionを使ったデータ取得 (バックグラウンド)
        
		@Override
        protected String doInBackground(URL... url) {
            String result = "";
            HttpsURLConnection urlConnection = null;
            try {
                urlConnection = (HttpsURLConnection) url[0].openConnection();
                urlConnection.setHostnameVerifier(new HostnameVerifier() {
                    @Override
					public boolean verify(String arg0, SSLSession arg1) {
						// TODO Auto-generated method stub
						return true;
					}
                });
                result = IOUtils.toString(urlConnection.getInputStream(),"UTF-8");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
            }
            return result;
        }

        // データ取得結果のTextViewへの表示 (UIスレッド)
        @Override
        protected void onPostExecute(String response) {
        	HttpsURLconnectiontest.this.textView.setText(response);
        }
    }
}



 
    