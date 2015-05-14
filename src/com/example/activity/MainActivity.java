package com.example.activity;

import java.util.Timer;
import java.util.TimerTask;

import com.example.app.Constant;
import com.example.fragment.Frag_Message;
import com.example.fragment.Frag_Parks;
import com.example.fragment.Frag_Person;
import com.example.vCar.R;

import de.greenrobot.event.EventBus;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.Toast;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		EventBus.getDefault().register(this);
		setParksFragment();

	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event){
		if(keyCode == KeyEvent.KEYCODE_BACK)
		{ 
		 exitBy2Click();
		}
		 return false;
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		EventBus.getDefault().unregister(this);
		super.onDestroy();
	}
	public void onEventMainThread(Message message) {
		switch (message.what) {
		case Constant.MESG_GAUIDEFRAG_PARKS:
			setParksFragment();
			break;
		case Constant.MESG_GAUIDEFRAG_PERSON:
			setPersonFragment();
			break;
		case Constant.MESG_GAUIDEFRAG_MESG:
			setMesgFragment();
			break;
		case Constant.MESG_PERSONFRAG_RELOAD:
			startActivity(new Intent().setClass(MainActivity.this, LoadActivity.class));
			finish();
			System.out.println("----------");
			break;
        case Constant.MESG_PERSONFRAG_MYPARK:
			
			break;
        case Constant.MESG_PERSONFRAG_UPDATE:
	        Toast.makeText(getApplication(), "已是最新版本", Toast.LENGTH_SHORT).show();
	        break;
        case Constant.MESG_PERSONFRAG_EXIT:
        	ExitAlertDialog();
	        break;

		default:
			break;
		}
	}

	/**
	 * 双击退出函数
	 */
	private static Boolean isExit = false;
	private void exitBy2Click() {
		 Timer tExit = null;
		 if (isExit == false) {
		 isExit = true; // 准备退出
		 Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
		 tExit = new Timer();
		 tExit.schedule(new TimerTask() {
		  @Override
		  public void run() {
		  isExit = false; // 取消退出
		  }
		 }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务
		 
		 } else {
		 finish();
		 System.exit(0);
		 }
		 }
		 
	protected void ExitAlertDialog(){
		  AlertDialog.Builder builder=new Builder(MainActivity.this);
		  builder.setMessage("真的要退出吗？");
		  builder.setTitle("提示");
		  
		  builder.setPositiveButton("确认", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				MainActivity.this.finish();
			}
		});
		  
		  builder.setNegativeButton("取消", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});
		  builder.create().show();
	}

	private void setMesgFragment() {
		// TODO Auto-generated method stub
		FragmentManager fragmentManager=getSupportFragmentManager();
		FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
		Frag_Message frag_MessageList=new Frag_Message();
		fragmentTransaction.replace(R.id.fl_mainactivity_center, frag_MessageList);
		fragmentTransaction.commit();
	}

	private void setPersonFragment() {
		// TODO Auto-generated method stub
		FragmentManager fragmentManager=getSupportFragmentManager();
		FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
		Frag_Person frag_PersonalPark=new Frag_Person();
		fragmentTransaction.replace(R.id.fl_mainactivity_center, frag_PersonalPark);
		fragmentTransaction.commit();
	}

	private void setParksFragment() {
		// TODO Auto-generated method stub
		FragmentManager fragmentManager=getSupportFragmentManager();
		FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
		Frag_Parks frag_ParkList=new Frag_Parks();
		fragmentTransaction.replace(R.id.fl_mainactivity_center, frag_ParkList);
		fragmentTransaction.commit();
	}
	
}
