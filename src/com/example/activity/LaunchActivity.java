package com.example.activity;

import com.example.vCar.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LaunchActivity extends Activity {

	protected int _splashTime = 5000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_launch);
		
		new Handler().postDelayed(new Runnable() {
			public void run() {
				Intent intent=new Intent();
				intent.setClass(LaunchActivity.this, LoadActivity.class);
				startActivity(intent);
				finish();
			}
		}, _splashTime);
	}
}
