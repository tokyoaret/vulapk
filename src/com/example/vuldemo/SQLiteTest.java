package com.example.vuldemo;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.database.*;
import android.database.sqlite.*;
import android.widget.LinearLayout;
import android.widget.TextView;


public class SQLiteTest extends Activity {

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sqlite_test);
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        setContentView(ll);

	
	

	//データベースを作成
	SQLiteDatabase db = openOrCreateDatabase("sample.db",Context.MODE_WORLD_READABLE | Context.MODE_WORLD_WRITEABLE,null);

	//テーブル作成用のクエリ文
	String query_table1 = "DROP TABLE IF EXISTS menber";
	String query_table2 = "CREATE TABLE menber"+ "( id INTEGER PRIMARY KEY, name STRING)";

	//テーブルの作成
	db.execSQL(query_table1);
	db.execSQL(query_table2);

	//レコード作成用のクエリ文(INSERT)
	String query_record_set[]   =   { 
	          "INSERT INTO menber( name ) VALUES ( 'john' ) ",
	          "INSERT INTO menber( name ) VALUES ( 'mike' ) ",
	          "INSERT INTO menber( name ) VALUES ( 'kim' ) ",
	          "INSERT INTO menber( name ) VALUES ( 'tanaka' ) ",
	          "INSERT INTO menber( name ) VALUES ( 'nicole' ) ",
	          "INSERT INTO menber( name ) VALUES ( 'angela' ) ",
	          "INSERT INTO menber( name ) VALUES ( 'ono' ) " };

	 //レコード作成
	 for( int i=0; i<query_record_set.length; i++){
	          db.execSQL(query_record_set[i]);
	 }


	 //レコード検索用のクエリ文(SELECT)
	 String query_select ="SELECT * FROM menber";
	 Cursor cursor = db.rawQuery(query_select, null);
	 startManagingCursor(cursor);
	 String result_str = "";
	 while( cursor.moveToNext() ){
	          int index_id    =   cursor.getColumnIndex("id");
	          int index_name  =   cursor.getColumnIndex("name");
	          int id          =   cursor.getInt(index_id);
	          String name     =   cursor.getString(index_name);
	          result_str      += "ID: " + id + " NAME:" +  name + "\n";
	 }

	 //内容表示用のTextView
	 TextView tv = new TextView(this);
	 tv.setText( result_str );
	 ll.addView(tv);
	}
}

	
