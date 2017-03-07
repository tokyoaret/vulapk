package com.example.vuldemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;

/**
 * This is code demo to send two different custom intents.
 * 
 * 
 */
public class MainFragment extends Fragment {

	String TAG= "MainFragment";
	
	public MainFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View myView = inflater.inflate(R.layout.fragment_main, container, false);
		
		//setup button to send an intent for static registered receiver.
		myView.findViewById(R.id.button1).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(MainActivity.ACTION1);
				getActivity().sendBroadcast(i);
			}
		});
		
		//setup button to send an intent for dynamic registered receiver, which is registered in MainActivity.
		myView.findViewById(R.id.button2).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(MainActivity.ACTION2);
				getActivity().sendBroadcast(i);
				//Log.v(TAG, "Should have sent the broadcast.");
			}
		});
		
		//call webview_test1
		myView.findViewById(R.id.button3).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent i = new Intent(getActivity(),WebViewTestActivity.class);
				startActivity(i);
				
			}


		});
		
		//call webview_test2
				myView.findViewById(R.id.button4).setOnClickListener(new OnClickListener() {
					@Override
					public void onClick(View view) {
						Intent i = new Intent(getActivity(),WebViewTestActivity2.class);
						startActivity(i);
						
					}


				});
				
		//call webview_test2
		myView.findViewById(R.id.button5).setOnClickListener(new OnClickListener() {
		@Override
					public void onClick(View view) {
						Intent i = new Intent(getActivity(),HttpsURLconnectiontest.class);
						startActivity(i);
						
					}


		});
		//call samplehttps
		myView.findViewById(R.id.button6).setOnClickListener(new OnClickListener() {
		@Override
						public void onClick(View view) {
							Intent i = new Intent(getActivity(),SampleHttps.class);
							startActivity(i);
							
						}


		});
		//call sqlitetest
		myView.findViewById(R.id.button7).setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View view) {
			Intent i = new Intent(getActivity(),SQLiteTest.class);
			startActivity(i);	
		}


		});
		
		//call sqlitetest
		myView.findViewById(R.id.button8).setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View view) {
			Intent i = new Intent(getActivity(),ReadContentProviderTest.class);
			startActivity(i);
							
		}


		});
		//call obscured
		myView.findViewById(R.id.button9).setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View view) {
		Intent i = new Intent(getActivity(),TouchFilterSample.class);
		startActivity(i);
									
				}


				});
		
		return myView;
	}

}
