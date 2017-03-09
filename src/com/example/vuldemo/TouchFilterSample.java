package com.example.vuldemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class TouchFilterSample extends Activity  implements OnClickListener{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_touch_filter_sample);
		
		Button btn1 = (Button)findViewById(R.id.filtering_button);
        btn1.setOnClickListener(this);
        Button btn2 = (Button)findViewById(R.id.no_filtering_button);
        btn2.setOnClickListener(this);
        setTouchFilter(btn1);
        
        
	}
	public void onClick(View v) {
		//Toast.makeText(this,"clicked" , Toast.LENGTH_SHORT).show();
		if(v.getId() == R.id.filtering_button){
	    	//偽トースト生成
			View view = new View(this);
			view.setLayoutParams(new ViewGroup.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT));
			view.setBackgroundColor(Color.argb(100,100,200,200));
			Toast toast = new Toast(TouchFilterSample.this);
			toast.setView(view);
 	    	//Toast toast = Toast.makeText(TouchFilterSample.this, "安全です¥安全です¥安全", Toast.LENGTH_LONG);
	       	toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
	        // トースト表示
	       	toast.show();
	    }else if(v.getId() == R.id.no_filtering_button){
    		AlertDialog.Builder b = new AlertDialog.Builder(this);
    		b.setTitle("Alert");
    		b.setMessage("ボタンは押されました。100円振り込んでください。");
    		b.show();
    	}
    }
	
	
	
	
	public void showToast(View v){
		View view = new View(this);
		view.setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT,
				ViewGroup.LayoutParams.WRAP_CONTENT));
		view.setBackgroundColor(Color.argb(100,100,200,200));
		
		Toast toast = new Toast(TouchFilterSample.this);
		toast.setView(view);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.show();
		
	}
	
	public void setTouchFilter(Button button) {
        button.setOnTouchListener(new OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                if ((event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) != 0) {
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                		AlertDialog.Builder b = new AlertDialog.Builder(TouchFilterSample.this);
                		b.setTitle("Alert");
                		b.setMessage("このボタンは危険です！");
                		b.show();
                    }
                    return true;
                }
                return false;
            }
        });
    }
	
	
}
