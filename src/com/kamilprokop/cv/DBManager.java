package com.kamilprokop.cv;

import java.util.ArrayList;

import android.content.Context;

public class DBManager
{
	private static DBManager mInstance;
	private DBHelper mDB;
	
	protected DBManager(Context context)
	{
		mDB = new DBHelper(context);
	}
	
	public static DBManager getInstance(Context context)
	{
		if(mInstance == null)
			mInstance = new DBManager(context.getApplicationContext());
		
		return mInstance;
	}
	
	public ArrayList<CvEntry> querySchools()
	{
		DBHelper.EntryCursor c = mDB.querySchools();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();
		
		while(c.moveToNext())
			cve.add(c.getEntry());
		
		c.close();
		
		return cve;
	}
	
	public ArrayList<CvEntry> queryExperience()
	{
		DBHelper.EntryCursor c = mDB.queryExperience();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();
		
		while(c.moveToNext())
			cve.add(c.getEntry());
		
		c.close();
		
		return cve;
	}
	
	public ArrayList<CvEntry> queryAdditional()
	{
		DBHelper.EntryCursor c = mDB.queryAdditional();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();
		
		while(c.moveToNext())
			cve.add(c.getEntry());
		
		c.close();
		
		return cve;
	}
	
	public ArrayList<CvEntry> queryLanguages()
	{
		DBHelper.EntryCursor c = mDB.queryLanguages();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();
		
		while(c.moveToNext())
			cve.add(c.getEntry());
		
		c.close();
		
		return cve;
	}
	
	public ArrayList<CvEntry> queryHobby()
	{
		DBHelper.EntryCursor c = mDB.queryHobby();
		ArrayList<CvEntry> cve = new ArrayList<CvEntry>();
		
		while(c.moveToNext())
			cve.add(c.getEntry());
		
		c.close();
		
		return cve;
	}
}
