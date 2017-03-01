package com.example.vuldemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.commons.io.IOUtils;

public class SampleHttps extends Activity implements X509TrustManager{
	TextView textView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sample_https);
		this.textView = (TextView) findViewById(R.id.samplehttps);
		
		// 接続先のURLを指定してHTTP GET実行
        URL url = null;
        try {
            url = new URL("https://www.google.co.jp");
            
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        }
        new HttpGetTask().execute(url);
        
    }
	
	class HttpGetTask extends AsyncTask<URL, Void, String> {
		
		@Override
        protected String doInBackground(URL... url) {
			String result = "";
			HttpsURLConnection urlConnection = null;
			try {
				urlConnection = (HttpsURLConnection) url[0].openConnection();
				
				
				if (urlConnection instanceof HttpsURLConnection) {
					Log.v("hhhhhh","instance");
					SSLContext context = SSLContext.getInstance("SSL");
					context.init(null, new TrustManager[]{}, null);
					SSLSocketFactory sf = context.getSocketFactory();
					
					
					
					urlConnection.setHostnameVerifier(new HostnameVerifier() {
	                    @Override
						public boolean verify(String arg0, SSLSession arg1) {
							// TODO Auto-generated method stub
							return true;
						}
	                });
				
				}//if
				Log.v("hhhhhh","noinstance");
				/////
				Map map = null;
				Object key = null;
				Iterator it = null;
				map = urlConnection.getRequestProperties();
				it = map.keySet().iterator();
				while (it.hasNext()) {
					key = it.next();
					System.out.println("" + key + " : " + map.get(key));
					Log.v("print: ", "" + key + " : " + map.get(key));
				}//while
				
			result = IOUtils.toString(urlConnection.getInputStream(),"UTF-8");
			
			} catch (IOException e) {
				e.printStackTrace();
				Log.v("hhhhhh","hhh222");
			} catch (GeneralSecurityException e) {
				e.printStackTrace();
				//Log.v("hhhhhh","hhh3");
			} finally{
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
			}
			return result;	
		}
		
		@Override
        protected void onPostExecute(String response) {
        	SampleHttps.this.textView.setText(response);
        }
	
	}

	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1)
			throws CertificateException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public X509Certificate[] getAcceptedIssuers() {
		// TODO Auto-generated method stub
		return null;
	}
}	



	
