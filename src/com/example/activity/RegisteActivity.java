package com.example.activity;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import com.example.vCar.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class RegisteActivity extends Activity {

	private EditText et_phonenumber;
	private EditText et_idebtifycode;
	private Button bt_getidentifycode;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registe);
		
		et_phonenumber=(EditText)findViewById(R.id.et_registeactivity_phonenumber);
		et_idebtifycode=(EditText)findViewById(R.id.et_registeactivity_identifycode);
		String phonenumber=et_phonenumber.getText().toString();
		String identifycodeString=et_idebtifycode.getText().toString();
		
		bt_getidentifycode=(Button)findViewById(R.id.bt_registeactivity_getidentifycode);
		bt_getidentifycode.setOnClickListener(new GetIdentifyCode());
		
	}

	class GetIdentifyCode implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub		

		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registe, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
