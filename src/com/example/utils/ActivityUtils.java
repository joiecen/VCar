package com.example.utils;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ActivityUtils {
	// 保存所有的已打开的activity
	public static ArrayList<Activity> ALL_ACTIVITY = new ArrayList<Activity>();

	public static void exitApp() {
		for (Activity ac : ALL_ACTIVITY) {
			if (!ac.isFinishing()) {
				ac.finish();
			}
		}
		ALL_ACTIVITY.clear();
		// HttpClient httpClient = CustomerHttpClient.getInstance();
		// if (httpClient != null && httpClient.getConnectionManager() != null)
		// {
		// httpClient.getConnectionManager().shutdown();
		// }
	}

	public static void addAppActivity(Activity activity) {
		if (!ALL_ACTIVITY.contains(activity)) {
			ALL_ACTIVITY.add(activity);
		}
	}

	public static void removeAppActivity(Activity activity) {
		if (ALL_ACTIVITY.contains(activity)) {
			ALL_ACTIVITY.remove(activity);
		}
	}

	public static void intentForward(Context context, Class<?> cls) {
		context.startActivity(new Intent(context, cls));
	}

	public static void intentForward(Context context, Intent intent) {
		context.startActivity(intent);
	}

	public static void intentForward(Context context, Class<?> cls, Intent intent) {
		context.startActivity(intent.setClass(context, cls));
	}

	public static Activity getActivityByName(String name) {
		Activity ia = null;
		for (Activity ac : ALL_ACTIVITY) {
			if (ac.getClass().getName().indexOf(name) >= 0) {
				ia = ac;
			}
		}
		return ia;
	}

	public static void showToast(Context context, String text) {
		Toast.makeText(context, text, Toast.LENGTH_LONG).show();
	}
}
