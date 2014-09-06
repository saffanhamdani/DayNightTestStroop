package com.exectivefunctiontest.stroop;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class dbDataSource {
	dbOpenHelper dbHelper;	//
	SQLiteDatabase database;	//
	String firstName;
	String lastName;
	int age;
	
	private static final String LOGTAG = "EXPLORECA";
	
	static final String[] allColumns={
		dbOpenHelper.COLUMN_ID, 
		dbOpenHelper.COLUMN_FIRST_NAME,
		dbOpenHelper.COLUMN_LAST_NAME,
		dbOpenHelper.COLUMN_AGE,
		dbOpenHelper.COLUMN_RESPONSE_ONE,
		dbOpenHelper.COLUMN_RESPONSE_TWO,
		dbOpenHelper.COLUMN_RESPONSE_THREE,
		dbOpenHelper.COLUMN_RESPONSE_FOUR,
		dbOpenHelper.COLUMN_RESPONSE_FIVE,
		dbOpenHelper.COLUMN_RESPONSE_SIX,
		dbOpenHelper.COLUMN_RESPONSE_SEVEN,
		dbOpenHelper.COLUMN_RESPONSE_EIGHT,
		dbOpenHelper.COLUMN_RESPONSE_NINE,
		dbOpenHelper.COLUMN_RESPONSE_TEN,
		dbOpenHelper.COLUMN_RESPONSE_ELEVEN,
		dbOpenHelper.COLUMN_RESPONSE_TWELVE,
		dbOpenHelper.COLUMN_RESPONSE_THIRTEEN,
		dbOpenHelper.COLUMN_RESPONSE_FOURTEEN,
		dbOpenHelper.COLUMN_RESPONSE_FIFTEEN,
		dbOpenHelper.COLUMN_RESPONSE_SIXTEEN
	};
	public dbDataSource(Context context) {
		
		dbHelper= new dbOpenHelper(context);//
		// TODO Auto-generated constructor stub
		database=dbHelper.getWritableDatabase();
		
	}
	public long recordNameAge(String fname, String lname, int age)
	
	{this.firstName=fname;
	this.lastName=lname;
	this.age=age;
		ContentValues values= new ContentValues();
	values.put(dbOpenHelper.COLUMN_FIRST_NAME,this.firstName);
	values.put(dbOpenHelper.COLUMN_LAST_NAME,this.lastName);
	values.put(dbOpenHelper.COLUMN_AGE,this.age);
	long insertId=database.insert(dbOpenHelper.TABLE_RESPONSE, null, values);	
	return insertId;
		}
	
	public void open() {
		
 	//	log("Database Opnened");		
	}

	public void close() {
	dbHelper.close();
	// log("Database Closed");
	}


public void log(String msg){
	Log.i(LOGTAG, msg);
}

/*
public Response createRow(Response myResponse){
	ContentValues values= new ContentValues();
	values.put(dbOpenHelper.COLUMN_FIRST_NAME,myResponse.getFirstName());
	values.put(dbOpenHelper.COLUMN_LAST_NAME,myResponse.getLastName());
	values.put(dbOpenHelper.COLUMN_AGE,myResponse.getAge());
	values.put(dbOpenHelper.COLUMN_RESPONSE_ONE,myResponse.getResponse1());
	values.put(dbOpenHelper.COLUMN_RESPONSE_TWO,myResponse.getResponse2());
	values.put(dbOpenHelper.COLUMN_RESPONSE_THREE,myResponse.getResponse3());
	values.put(dbOpenHelper.COLUMN_RESPONSE_FOUR,myResponse.getResponse4());
	long insertId=database.insert(dbOpenHelper.TABLE_RESPONSE, null, values);
	myResponse.setId(insertId);
	return myResponse;
	
	}
	*/
public int updateRecord(ContentValues values, int id)
{int rowsAffected=database.update(dbOpenHelper.TABLE_RESPONSE, values, dbOpenHelper.COLUMN_ID+"="+id, null);
return rowsAffected;
}

	public Cursor findall(){
	Cursor cursor=database.query(dbOpenHelper.TABLE_RESPONSE, allColumns, 
			null, null, null, null, null);
//	log("Returned "+ cursor.getCount()+"rows");	
/*	List <Response> responses=new ArrayList<Response>();
	if(cursor.getCount()>0)
	{
		while(cursor.moveToNext()){
			log("reached point 1");
			Response responseRow=new Response();
			log("reached point 2");
		responseRow.setId(cursor.getLong(cursor.getColumnIndex(dbOpenHelper.COLUMN_ID)));
		log("reached point 3");
		responseRow.setFirstName(cursor.getString(cursor.getColumnIndex(dbOpenHelper.COLUMN_FIRST_NAME)));
		log("reached point 4");
		responseRow.setLastName(cursor.getString(cursor.getColumnIndex(dbOpenHelper.COLUMN_LAST_NAME)));
		log("reached point 5");
		responseRow.setAge(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_AGE)));
		log("reached point 6");
		responseRow.setResponse1(cursor.getInt(cursor.getColumnIndexOrThrow(dbOpenHelper.COLUMN_RESPONSE_ONE)));
		log("reached point 7");
		responseRow.setResponse2(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_TWO)));
		log("reached point 8");
		responseRow.setResponse3(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_THREE)));
		log("reached point 9");
		//responseRow.setResponse4(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_FOUR)));
		responses.add(responseRow);		
			}
		}*/
	return cursor;
	}

}
