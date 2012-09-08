package com.rahulbudhiraja.udptest;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

import android.os.Bundle;
import android.util.Log;

import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class UDPtestActivity extends Activity  {
    /** Called when the activity is first created. */
	 
	TextView textv;
	TouchEventClassifier touch; 
	
	public void onCreate(Bundle icicle) {
	       super.onCreate(icicle);
	       
	       touch=new TouchEventClassifier(this);

	       setContentView(R.layout.main);
	       
	       textv=(TextView)this.findViewById(R.id.textView);

	       
	     
	       /* Kickoff the Server, it will
	        * be 'listening' for one client packet */
	  
	       /* GIve the Server some time for startup */
	     
	       // Kickoff the Client
	      // new Thread(new Client()).start();
	   }
	 
	public boolean onTouchEvent(MotionEvent event) 
	{
		touch.processTouch(event);
		textv.setText(touch.getAction());
		Log.d("string length", "   "+touch.getAction());
		if(touch.getAction().length()>0)
		new Thread(new Client(touch.getAction())).start();
		touch.setAction("");
//		textv.setText("");
		return false;
	}
	

	
	
}