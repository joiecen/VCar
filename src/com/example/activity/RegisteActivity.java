package com.example.activity;

import com.example.vCar.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisteActivity extends Activity {

	private EditText et_phonenumber;
	private EditText et_idebtifycode;
	private EditText et_password;
	private EditText et_repassword;
	private Button bt_getidentifycode;
	private Button bt_registe;
	
	private String phonenumber;
	private String identifycode;
	private String password;
	private String repassword;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registe);
			
		et_phonenumber=(EditText)findViewById(R.id.et_registeactivity_phonenumber);
		et_idebtifycode=(EditText)findViewById(R.id.et_registeactivity_identifycode);
		et_password=(EditText)findViewById(R.id.et_registeactivity_password);
		et_repassword=(EditText)findViewById(R.id.et_registeactivity_repassword);
//	    phonenumber=et_phonenumber.getText().toString();
//		identifycode=et_idebtifycode.getText().toString();
//		password=et_password.getText().toString();
//		repassword=et_repassword.getText().toString();
		
		bt_getidentifycode=(Button)findViewById(R.id.bt_registeactivity_getidentifycode);
		bt_registe=(Button)findViewById(R.id.bt_registeactivity_registe);
		bt_getidentifycode.setOnClickListener(new GetIdentifyCode());
		bt_registe.setOnClickListener(new Registe());
		
		bt_registe.setEnabled(false);
		
	}
	
	class RepasswordTextWatcher implements TextWatcher{

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count) {
			// TODO Auto-generated method stub
			
	
		}

		@Override
		public void afterTextChanged(Editable s) {
			// TODO Auto-generated method stub
			
		}
		
	}
  

	class GetIdentifyCode implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub		

		}
	}
	class Registe implements OnClickListener{

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
