package com.example.vuldemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewTestActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview_test);
		///
		WebView  myWebView = (WebView)findViewById(R.id.webView1);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.loadUrl("https://google.co.jp");
		myWebView.setWebViewClient(new WebViewClient(){});		
		////////
		
		
		
	}

	
}
