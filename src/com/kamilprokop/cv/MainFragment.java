package com.kamilprokop.cv;

import java.util.ArrayList;

import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainFragment extends Fragment
{
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_main, container, false);
		
		ArrayList<CvEntry> al = DBManager.getInstance(getActivity()).querySchools();
		
		LinearLayout lay = (LinearLayout)v.findViewById(R.id.schools_container);
		
		TextView tv;
		
		for(int i = 0; i < al.size(); i++)
		{
			CvEntry cve = al.get(i);
			
			tv = new TextView(getActivity());
			tv.setText(cve.getContent());
			tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
			
			lay.addView(tv);
		}
		
		return v;
	}
}
