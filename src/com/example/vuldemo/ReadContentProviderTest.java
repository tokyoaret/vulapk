package com.example.vuldemo;

import java.util.Random;

import android.app.Activity;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class ReadContentProviderTest extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getIntent().setData(Uri.parse("content://com.example.vuldemo.myprovider"));

        ContentValues values = new ContentValues();
        values.put("name", "Random");
        Random r = new Random();
        int n = r.nextInt(50);
        values.put("description", "number:"+n);
        getContentResolver().insert(getIntent().getData(), values);

        Cursor cur = managedQuery(getIntent().getData(), null, null, null, null);
        while (cur.moveToNext()) {
            Log.d("cur:",cur.getString(1)+","+cur.getString(2));
            Toast.makeText(this,cur.getString(1)+","+cur.getString(2) , Toast.LENGTH_SHORT).show();
        }

        setContentView(R.layout.activity_read_content_provider_test);
    }
	 
        
    
        
}

