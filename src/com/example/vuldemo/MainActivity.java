package com.example.vuldemo;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/*
 * A simple demo of broadcast receiver and custom intent.
 * The fragment has the code to send the broadcast.
 * 
 * this code will register a dynamic intent-filter for Action2
 * action one is static registered in the manifest file.
 */

public class MainActivity extends FragmentActivity {

	//declare the intent names here, except if change ACTION1, fix it in AndroidManifest.xml as well.
	public static final String ACTION1 = "com.example.vuldemo.mystaticevent";//manifest
	public static final String ACTION2 = "com.example.vuldemo.mydyanicevent";
	
	String TAG = "MainActivity";
	
	MyReceiver mReceiver;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new MainFragment()).commit();
		}
		
		//need to initialize the variable here.  
		mReceiver = new MyReceiver();
		
	}

	@Override
	public void onResume() {
		super.onResume();
		// Register mReceiver to receive messages.
		// the local is not working, I don't know why...  Using general one.
		//LocalBroadcastManager.getInstance(this).registerReceiver(mReceiver, new IntentFilter(ACTION2));

		registerReceiver(mReceiver,  new IntentFilter(ACTION2));
		//Log.v(TAG, "receiver should be registered");
	}
	@Override
	protected void onPause() {  //or onDestory()
		// Unregister since the activity is not visible
		//again, local not working, 
		//LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
		unregisterReceiver(mReceiver);
		Log.v(TAG, "receiver should be unregistered");
		super.onPause();

	} 

}