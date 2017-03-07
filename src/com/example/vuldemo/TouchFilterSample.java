package com.example.vuldemo;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TouchFilterSample extends Activity  implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_touch_filter_sample);
		
		Button btn1 = (Button)findViewById(R.id.filtering_button);
        btn1.setOnClickListener((OnClickListener) this);
        Button btn2 = (Button)findViewById(R.id.no_filtering_button);
        btn2.setOnClickListener((OnClickListener) this);
        
        
	}
	public void onClick(View v) {
		Toast.makeText(this,"clicked" , Toast.LENGTH_LONG).show();
    }
	
	
	
	public void showToast(View v){
		View view = new View(this);
		view.setLayoutParams(new ViewGroup.
				LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,
							 ViewGroup.LayoutParams.FILL_PARENT));
		view.setBackgroundColor(Color.argb(128,128,128,128));
		Toast toast = new Toast(this);
		toast.setView(view);
		toast.setDuration(5000);
		toast.show();
		
	}
	
	
	
	
}
