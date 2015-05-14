package com.example.fragment;

import com.example.app.Constant;
import com.example.vCar.R;
import de.greenrobot.event.EventBus;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class Frag_Person extends Fragment {

	private Button reload;
	private Button myparks;
	private Button update;
	private Button exit;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_person, container, false);
		
		reload=(Button)view.findViewById(R.id.bt_frag_person_reload);
		myparks=(Button)view.findViewById(R.id.bt_frag_person_manage);
		update=(Button)view.findViewById(R.id.bt_frag_person_update);
		exit=(Button)view.findViewById(R.id.bt_frag_person_exit);
		
		reload.setOnClickListener(onClickListener);
		myparks.setOnClickListener(onClickListener);
		update.setOnClickListener(onClickListener);
		exit.setOnClickListener(onClickListener);
		return view;
		
	}
	
	private OnClickListener onClickListener=new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Message message=new Message();
			switch (v.getId()) {
			case R.id.bt_frag_person_reload:
				message.what=Constant.MESG_PERSONFRAG_RELOAD;
				EventBus.getDefault().post(message);
				System.out.println("++++++++++++++");
				break;
            case R.id.bt_frag_person_manage:
            	message.what=Constant.MESG_PERSONFRAG_MYPARK;
				EventBus.getDefault().post(message);
				break;
            case R.id.bt_frag_person_update:
            	message.what=Constant.MESG_PERSONFRAG_UPDATE;
				EventBus.getDefault().post(message);
	            break;
            case R.id.bt_frag_person_exit:
            	message.what=Constant.MESG_PERSONFRAG_EXIT;
				EventBus.getDefault().post(message);
	            break;

			default:
				break;
			}
			
		}
	};
}
