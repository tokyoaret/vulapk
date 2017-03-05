package com.example.vuldemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewTestActivity2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview_test2);
		///
		WebView  myWebView = (WebView)findViewById(R.id.webView2);
		myWebView.getSettings().setJavaScriptEnabled(true);
		

		
		////String html = "<html><script>alert(1)</script></html>";
		////myWebView.loadData(html, "text/html", "utf-8");
		
		//myWebView.addJavascriptInterface(new JsObject(), "injectedObject");
		//String script = "javascript:document.write(injectedObject.toString());document.write('zz')";		
		//myWebView.loadUrl(script);
		
		myWebView.loadUrl("file:///android_asset/index.html");
		
		//myWebView.getSettings().setAllowFileAccess(false);
		//myWebView.loadUrl("file:///default.prop");
		//myWebView.loadUrl("file:///system/etc/sysmon.cfg");
		
		//myWebView.evaluateJavascript(script,null); < api19
		
		myWebView.setWebViewClient(new WebViewClient(){
		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
		            
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
		startActivity( intent );
		return true;
		}});
		//@Override  
		//public boolean onJsAlert
				
		
		////////
	}
}

class JsObject {
	  //JavaScriptから呼び出したいメソッド
	  @JavascriptInterface
	  public String toString() { return "injectedObject!!!"; }
	}

