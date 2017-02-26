package com.example.vuldemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/*
 * A simple demo of receiving custom intents.
 * action1 is registered statically in the manifest file and action2 is dynamically registered 
 * in the mainActivity code.
 * 
 * The variables ACTION1 and ACTION2 are declared in the MainActivity as well.
 */

public class MyReceiver extends BroadcastReceiver {

	
	@Override
	public void onReceive(Context context, Intent intent) {
		
		Toast.makeText(context, "Received an intent.", Toast.LENGTH_SHORT).show();
		
		if (intent.getAction().equals(MainActivity.ACTION1)){ //is it our action1?
			Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
			Log.v("received data: ", intent.getAction() + "/" + intent.getExtras());
		} else if (intent.getAction().equals(MainActivity.ACTION2)){ //is it our action2?
			Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
			Log.v("received data: ", intent.getAction() +"/" + intent.getExtras());
		} else if (intent.getAction().equals("android.appwidget.action.APPWIDGET_UPDATE")){ //is it our action2?
			Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
			Log.v("received data: ", intent.getAction() + "/" + intent.getExtras());
		}
		  else if (intent.getAction().equals("jp.co.rakuten.sdtd.user.APP_LOGIN")){ //is it our action2?
			Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
			Log.v("received data: ", intent.getAction() +"/" + intent.getExtras());
		} 
		  else if (intent.getAction().equals("jp.co.rakuten.sdtd.user.APP_LOGOUT")){ //is it our action2?
				Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.v("received data: ", intent.getAction() +"/"+ intent.getExtras());
			}
		  else if (intent.getAction().equals("jp.co.rakuten.android.DEVICE_REGISTERED_TO_GCM")){ //is it our action2?
				Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.v("received data: ", intent.getAction() + "/" + intent.getExtras());
			}
		  else if (intent.getAction().equals("jp.co.rakuten.android.ADVERTISING_ID_UPDATE")){ //is it our action2?
			  Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.v("received data: ", intent.getAction() +"/"+ intent.getExtras());
				System.out.println(intent.getAction() + "/" + intent.getExtras());
			}
		  else if (intent.getAction().equals("jp.co.rakuten.android.BROADCAST_PUSH_TYPE_CONFIG_UPDATED")){ //is it our action2?
			  Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.v("received data: ", intent.getAction() +"/"+ intent.getExtras());
			}
		  else if (intent.getAction().equals("jp.co.rakuten.android.intent.APPBOY_NOTIFICATION_OPENED")){ //is it our action2?
			  Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.v("received data: ", intent.getAction() +"/"+ intent.getExtras());
			}
		  else if (intent.getAction().equals("com.android.vending.INSTALL_REFERRER")){ //is it our action2?
			  Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.v("received data: ", intent.getAction() +"/"+ intent.getExtras());
			}
		  else if (intent.getAction().equals("android.accounts.LOGIN_ACCOUNTS_CHANGED")){ //is it our action2?
			  Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.d("received data: ", intent.getAction() +"/"+ intent.getExtras());
			}
		  else if (intent.getAction().equals("android.intent.action.battery_low")){ //is it our action2?
				Toast.makeText(context, intent.getAction() + "/" +intent.getExtras(), Toast.LENGTH_SHORT).show();
				Log.d("received data: ", intent.getAction() + "/" + intent.getExtras());
				System.out.println(intent.getAction() + "/" + intent.getExtras());
			}
		  
	}
}
