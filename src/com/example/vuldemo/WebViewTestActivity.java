package com.example.vuldemo;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.SslErrorHandler;
import android.net.http.SslError;

public class WebViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview_test);
		///
		WebView  myWebView = (WebView)findViewById(R.id.webView1);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.loadUrl("https://www.google.co.jp");
		myWebView.setWebViewClient(new WebViewClient()
		//in case of not install proxycert.crt
		//{
			//@Override  
		    //public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error)
			//{  
	       //handler.proceed();  
	        //}  
		//}
	);		
		////////
		
		
		
	}

	
}
