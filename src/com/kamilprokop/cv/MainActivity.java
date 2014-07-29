package com.kamilprokop.cv;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

public class MainActivity extends Activity
{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		getActionBar().setTitle(R.string.cv);
		setContentView(R.layout.activity_main);

		FragmentManager fm = getFragmentManager();
		Fragment f = fm.findFragmentById(R.id.main_container);

		if (f == null)
		{
			f = new MainFragment();

			fm.beginTransaction().add(R.id.main_container, f).commit();
		}
	}
}
