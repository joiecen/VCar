package com.example.activity;

import com.example.vCar.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class LoadActivity extends Activity {

	private EditText et_account;
	private EditText et_password;
	private Button btn_load;
	private Button btn_registe;
	private Button btn_forgetpassword;
	private Button btn_steppass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_load);
		
		et_account=(EditText)findViewById(R.id.et_loadactivity_account);
		et_password=(EditText)findViewById(R.id.et_loadactivity_password);
		String account=et_account.getText().toString();
		String password=et_password.getText().toString();
		
		btn_load=(Button)findViewById(R.id.bt_loadactivity_load);
		btn_registe=(Button)findViewById(R.id.bt_loadactivity_registe);
		btn_forgetpassword=(Button)findViewById(R.id.bt_loadactivity_forgetpassword);
		btn_steppass=(Button)findViewById(R.id.bt_loadactivity_steppass);
		
		btn_load.setOnClickListener(new LoadButton());
		btn_registe.setOnClickListener(new RegisteButton());
		btn_forgetpassword.setOnClickListener(new ForgetpasswordButton());
		btn_steppass.setOnClickListener(new SteppassButton());
		
	}
	
	class LoadButton implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(LoadActivity.this,MainActivity.class);
			startActivity(intent);
			finish();
		}
		
	}
	
	class RegisteButton implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent intent=new Intent();
			intent.setClass(LoadActivity.this,RegisteActivity.class);
			startActivity(intent);
		}
		
	}
	
	class ForgetpasswordButton implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			
		}
		
	}
	class SteppassButton implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.load, menu);
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
