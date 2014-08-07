package com.kamilprokop.cv;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWrapper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper
{
	private static final String DB_NAME = "cv.sqlite";
	private static final int DB_VERSION = 1;

	public DBHelper(Context context)
	{
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db)
	{
		db.execSQL("CREATE TABLE entries (_id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ "category VARCHAR(160),"
				+ "position INTEGER,"
				+ "annotation VARCHAR(160),"
				+ "header VARCHAR(160),"
				+ "content VARCHAR(500))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
	}

	public EntryCursor querySchools()
	{
		Cursor c = getReadableDatabase().query("entries", null, "category=?",
				new String[] { "schools" }, null, null, "position");

		return new EntryCursor(c);
	}

	public EntryCursor queryExperience()
	{
		Cursor c = getReadableDatabase().query("entries", null, "category=?",
				new String[] { "experience" }, null, null, "position");

		return new EntryCursor(c);
	}

	public EntryCursor queryAdditional()
	{
		Cursor c = getReadableDatabase().query("entries", null, "category=?",
				new String[] { "additional" }, null, null, "position");

		return new EntryCursor(c);
	}

	public EntryCursor queryLanguages()
	{
		Cursor c = getReadableDatabase().query("entries", null, "category=?",
				new String[] { "languages" }, null, null, "position");

		return new EntryCursor(c);
	}

	public EntryCursor queryHobby()
	{
		Cursor c = getReadableDatabase().query("entries", null, "category=?",
				new String[] { "hobby" }, null, null, "position");

		return new EntryCursor(c);
	}

	public void initDB()
	{
		ContentValues cv = new ContentValues();
		cv.put("category", "schools");
		cv.put("position", 0);
		cv.put("annotation", "10.2012-07.2014");
		cv.put("header", "Uniwersytet Śląski w Katowicach");
		cv.put("content", "Sosnowiec, Informatyka, magisterskie, stacjonarne");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "schools");
		cv.put("position", 1);
		cv.put("annotation", "10.2009-06.2012");
		cv.put("header", "Uniwersytet Śląski w Katowicach");
		cv.put("content", "Katowice, Informatyka, licencjackie, stacjonarne");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "experience");
		cv.put("position", 0);
		cv.put("annotation", "2007-2014");
		cv.put("header", "Freelancer");
		cv.put("content",
				"Software Developer, Web Developer.\nC# (.NET, Windows Phone, Mono),\nJava (SE, Android),\nC++ (Qt),\nPHP (Kohana, CodeIgniter, komponenty Joomla!),\nHTML, CSS, jQuery, JavaScript,\nMySQL, SQLite.");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "experience");
		cv.put("position", 1);
		cv.put("annotation", "09.2011");
		cv.put("header", "Miejska Biblioteka Publiczna w Jaworznie");
		cv.put("content",
				"Praktykant w Dziale IT.\nInstalacja urządzeń sieciowych, nadzór nad rozwiązaniami IT, instalacja i aktualizacja\nsystemów operacyjnych, wdrażanie oprogramowania, wsparcie dla użytkowników.");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "additional");
		cv.put("position", 0);
		cv.put("annotation", "zdane egzaminy");
		cv.put("header", "");
		cv.put("content",
				"ITA-105: Programowanie Obiektowe\nITA-102: Hurtownie Danych\nOffice ePack by Onex: Windows 7\nPrawo jazdy kat. B");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "additional");
		cv.put("position", 1);
		cv.put("annotation", "inne");
		cv.put("header", "");
		cv.put("content",
				"praca z relacyjnymi bazami danych\nznajomość systemu kontroli wersji Git\nznajomość systemu operacyjnego Linux");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "languages");
		cv.put("position", 0);
		cv.put("annotation", "angielski");
		cv.put("header", "");
		cv.put("content", "B1");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "languages");
		cv.put("position", 1);
		cv.put("annotation", "niemiecki");
		cv.put("header", "");
		cv.put("content", "A1");
		getWritableDatabase().insert("entries", null, cv);

		cv = new ContentValues();
		cv.put("category", "hobby");
		cv.put("position", 0);
		cv.put("annotation", "");
		cv.put("header", "");
		cv.put("content",
				"kolarstwo,\nmotoryzacja,\nmechanika,\nsprzęt elektroniczny.");
		getWritableDatabase().insert("entries", null, cv);
	}

	public static class EntryCursor extends CursorWrapper
	{
		public EntryCursor(Cursor c)
		{
			super(c);
		}

		public CvEntry getEntry()
		{
			CvEntry cve = new CvEntry();
			cve.setAnnotation(getString(getColumnIndex("annotation")));
			cve.setHeader(getString(getColumnIndex("header")));
			cve.setContent(getString(getColumnIndex("content")));

			return cve;
		}
	}

}
