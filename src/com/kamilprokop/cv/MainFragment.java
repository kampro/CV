package com.kamilprokop.cv;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainFragment extends Fragment
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		setHasOptionsMenu(true);
	}

	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater)
	{
		super.onCreateOptionsMenu(menu, inflater);

		inflater.inflate(R.menu.main_fragment, menu);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		View v = inflater.inflate(R.layout.fragment_main, container, false);

		ArrayList<CvEntry> al = DBManager.getInstance(getActivity())
				.querySchools();

		LinearLayout lay = (LinearLayout)v.findViewById(R.id.schools_container);

		TextView tv;

		for (int i = 0; i < al.size(); i++)
		{
			CvEntry cve = al.get(i);

			if (cve.getAnnotation().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.annotation_template,
						lay, false);
				tv.setText(cve.getAnnotation());

				lay.addView(tv);
			}

			if (cve.getHeader().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.header_template, lay,
						false);
				tv.setText(cve.getHeader());

				lay.addView(tv);
			}

			tv = (TextView)inflater.inflate(R.layout.content_template, lay,
					false);
			tv.setText(cve.getContent());

			lay.addView(tv);
		}

		al = DBManager.getInstance(getActivity()).queryExperience();

		lay = (LinearLayout)v.findViewById(R.id.experience_container);

		for (int i = 0; i < al.size(); i++)
		{
			CvEntry cve = al.get(i);

			if (cve.getAnnotation().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.annotation_template,
						lay, false);
				tv.setText(cve.getAnnotation());

				lay.addView(tv);
			}

			if (cve.getHeader().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.header_template, lay,
						false);
				tv.setText(cve.getHeader());

				lay.addView(tv);
			}

			tv = (TextView)inflater.inflate(R.layout.content_template, lay,
					false);
			tv.setText(cve.getContent());

			lay.addView(tv);
		}

		al = DBManager.getInstance(getActivity()).queryAdditional();

		lay = (LinearLayout)v.findViewById(R.id.additional_container);

		for (int i = 0; i < al.size(); i++)
		{
			CvEntry cve = al.get(i);

			if (cve.getAnnotation().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.annotation_template,
						lay, false);
				tv.setText(cve.getAnnotation());

				lay.addView(tv);
			}

			if (cve.getHeader().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.header_template, lay,
						false);
				tv.setText(cve.getHeader());

				lay.addView(tv);
			}

			tv = (TextView)inflater.inflate(R.layout.content_template, lay,
					false);
			tv.setText(cve.getContent());

			lay.addView(tv);
		}

		al = DBManager.getInstance(getActivity()).queryLanguages();

		lay = (LinearLayout)v.findViewById(R.id.languages_container);

		for (int i = 0; i < al.size(); i++)
		{
			CvEntry cve = al.get(i);

			if (cve.getAnnotation().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.annotation_template,
						lay, false);
				tv.setText(cve.getAnnotation());

				lay.addView(tv);
			}

			if (cve.getHeader().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.header_template, lay,
						false);
				tv.setText(cve.getHeader());

				lay.addView(tv);
			}

			tv = (TextView)inflater.inflate(R.layout.content_template, lay,
					false);
			tv.setText(cve.getContent());

			lay.addView(tv);
		}

		al = DBManager.getInstance(getActivity()).queryHobby();

		lay = (LinearLayout)v.findViewById(R.id.hobby_container);

		for (int i = 0; i < al.size(); i++)
		{
			CvEntry cve = al.get(i);

			if (cve.getAnnotation().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.annotation_template,
						lay, false);
				tv.setText(cve.getAnnotation());

				lay.addView(tv);
			}

			if (cve.getHeader().length() > 0)
			{
				tv = (TextView)inflater.inflate(R.layout.header_template, lay,
						false);
				tv.setText(cve.getHeader());

				lay.addView(tv);
			}

			tv = (TextView)inflater.inflate(R.layout.content_template, lay,
					false);
			tv.setText(cve.getContent());

			lay.addView(tv);
		}

		return v;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch (item.getItemId())
		{
		case R.id.menu_item_personal_data:
			FragmentManager fm = getFragmentManager();
			PersonalDataDialog pdd = new PersonalDataDialog();
			pdd.show(fm, "PersonalDataDialog");

			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
