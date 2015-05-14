package com.example.fragment;

import com.example.app.Constant;
import com.example.vCar.R;

import de.greenrobot.event.EventBus;

import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RadioButton;

public class Frag_Guide extends Fragment {
	private RadioButton rbt_parks;
	private RadioButton rbt_person;
	private RadioButton rbt_mesg;

	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.frag_guide, container, false);
		rbt_parks = (RadioButton) view.findViewById(R.id.rbt_fragguide_parks);
		rbt_person = (RadioButton) view.findViewById(R.id.rbt_fragguide_person);
		rbt_mesg = (RadioButton) view.findViewById(R.id.rbt_fragguide_mesg);
		rbt_parks.setOnClickListener(onClickListener);
		rbt_person.setOnClickListener(onClickListener);
		rbt_mesg.setOnClickListener(onClickListener);
		return view;
	}

	private OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Message message = new Message();
			switch (v.getId()) {
			case R.id.rbt_fragguide_parks:
				message.what = Constant.MESG_GAUIDEFRAG_PARKS;
				EventBus.getDefault().post(message);
				break;
			case R.id.rbt_fragguide_person:
				message.what = Constant.MESG_GAUIDEFRAG_PERSON;
				EventBus.getDefault().post(message);
				break;
			case R.id.rbt_fragguide_mesg:
				message.what = Constant.MESG_GAUIDEFRAG_MESG;
				EventBus.getDefault().post(message);
				break;

			default:
				break;
			}
		}
	};
}
