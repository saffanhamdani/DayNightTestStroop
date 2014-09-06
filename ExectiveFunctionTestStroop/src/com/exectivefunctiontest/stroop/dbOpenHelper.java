package com.exectivefunctiontest.stroop;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbOpenHelper extends SQLiteOpenHelper {

	private static final String LOGTAG = "EXPLORECA";

	private static final String DATABASE_NAME = "childResponse.db";
	private static final int DATABASE_VERSION = 3;
	
	public static final String TABLE_RESPONSE = "response";
	public static final String COLUMN_ID = "childId";
	public static final String COLUMN_FIRST_NAME = "FirstName";
	public static final String COLUMN_LAST_NAME = "LastName";
	public static final String COLUMN_AGE = "age";
	public static final String COLUMN_RESPONSE_ONE = "response1";
	public static final String COLUMN_RESPONSE_TWO = "response2";
	public static final String COLUMN_RESPONSE_THREE = "response3";
	public static final String COLUMN_RESPONSE_FOUR = "response4";
	public static final String COLUMN_RESPONSE_FIVE = "response5";
	public static final String COLUMN_RESPONSE_SIX = "response6";
	public static final String COLUMN_RESPONSE_SEVEN = "response7";
	public static final String COLUMN_RESPONSE_EIGHT = "response8";
	public static final String COLUMN_RESPONSE_NINE = "response9";
	public static final String COLUMN_RESPONSE_TEN = "response10";
	public static final String COLUMN_RESPONSE_ELEVEN = "response11";
	public static final String COLUMN_RESPONSE_TWELVE = "response12";
	public static final String COLUMN_RESPONSE_THIRTEEN = "response13";
	public static final String COLUMN_RESPONSE_FOURTEEN = "response14";
	public static final String COLUMN_RESPONSE_FIFTEEN = "response15";
	public static final String COLUMN_RESPONSE_SIXTEEN = "response16";
	
	private static final String TABLE_CREATE = 
			"CREATE TABLE " + TABLE_RESPONSE + " (" +
			COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
			COLUMN_FIRST_NAME + " TEXT, " +
			COLUMN_LAST_NAME + " TEXT, " +
			COLUMN_AGE + " INTEGER, " +
			COLUMN_RESPONSE_ONE + " INTEGER, " +
			COLUMN_RESPONSE_TWO + " INTEGER, " +
			COLUMN_RESPONSE_THREE + " INTEGER, " +
			COLUMN_RESPONSE_FOUR + " INTEGER, " +
			COLUMN_RESPONSE_FIVE + " INTEGER, " +
			COLUMN_RESPONSE_SIX + " INTEGER, " +
			COLUMN_RESPONSE_SEVEN + " INTEGER, " +
			COLUMN_RESPONSE_EIGHT + " INTEGER, " +
			COLUMN_RESPONSE_NINE + " INTEGER, " +
			COLUMN_RESPONSE_TEN + " INTEGER, " +
			COLUMN_RESPONSE_ELEVEN + " INTEGER, " +
			COLUMN_RESPONSE_TWELVE + " INTEGER, " +
			COLUMN_RESPONSE_THIRTEEN + " INTEGER, " +
			COLUMN_RESPONSE_FOURTEEN + " INTEGER, " +
			COLUMN_RESPONSE_FIFTEEN + " INTEGER, " +
			COLUMN_RESPONSE_SIXTEEN + " INTEGER " +						
			")";
				
	public dbOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		Log.i(LOGTAG, "Hello World.");
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
	db.execSQL(TABLE_CREATE);
		Log.i(LOGTAG, "Table has been created.");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS "+TABLE_RESPONSE);	//drop response table if it exists already	
		onCreate(db);
	}
}