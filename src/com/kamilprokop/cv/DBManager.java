package com.kamilprokop.cv;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class DBManager
{
	private static DBManager mInstance;
	private DBHelper mDB;
	private SharedPreferences preferences;
	public static final String DB_PREFS = "isDBfilled";

	protected DBManager(Context context)
	{
		mDB = new DBHelper(context);

		preferences = context.getSharedPreferences(DB_PREFS,
				Context.MODE_PRIVATE);

		if (!preferences.getBoolean(DB_PREFS, false))
		{
			Log.i("DBManager", "Initializing DB");

			mDB.initDB();

			preferences.edit().putBoolean(DB_PREFS, true).commit();
		}
	}

	public static DBManager getInstance(Context context)
	{
		if (mInstance == null)
			mInstance = new DBManager(context.getApplicationContext());

		return mInstance;
	}

	public ArrayList<CvEntry> querySchools()
	{
		DBHelper.EntryCursor c = mDB.querySchools();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();

		while (c.moveToNext())
			cve.add(c.getEntry());

		c.close();

		return cve;
	}

	public ArrayList<CvEntry> queryExperience()
	{
		DBHelper.EntryCursor c = mDB.queryExperience();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();

		while (c.moveToNext())
			cve.add(c.getEntry());

		c.close();

		return cve;
	}

	public ArrayList<CvEntry> queryAdditional()
	{
		DBHelper.EntryCursor c = mDB.queryAdditional();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();

		while (c.moveToNext())
			cve.add(c.getEntry());

		c.close();

		return cve;
	}

	public ArrayList<CvEntry> queryLanguages()
	{
		DBHelper.EntryCursor c = mDB.queryLanguages();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();

		while (c.moveToNext())
			cve.add(c.getEntry());

		c.close();

		return cve;
	}

	public ArrayList<CvEntry> queryHobby()
	{
		DBHelper.EntryCursor c = mDB.queryHobby();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();

		while (c.moveToNext())
			cve.add(c.getEntry());

		c.close();

		return cve;
	}
}
