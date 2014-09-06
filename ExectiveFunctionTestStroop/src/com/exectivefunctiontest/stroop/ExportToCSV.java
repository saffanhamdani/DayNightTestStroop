package com.exectivefunctiontest.stroop;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.database.Cursor;
import android.os.Environment;
import android.util.Log;

public class ExportToCSV {
	public static final String TAG="blablabla";
	
	
	Boolean success=backupDatabaseCSV("ChildResponses");
	
		
public	static Boolean backupDatabaseCSV(String outFileName) {
	    Log.d(TAG, "Exporting Database to CSV file");
	    Boolean returnCode = false;
	    int i = 0;
	    String csvHeader = "";
	    String csvValues = "";
	    Cursor GC=Main.datasource.findall();
	    for (i = 0; i < GC.getColumnCount(); i++) {
	        if (csvHeader.length() > 0) {
	            csvHeader += ",";
	        }
	        csvHeader += "\"" + dbDataSource.allColumns[i] + "\"";
	    }

	    csvHeader += "\n";
	    Log.d(TAG, "header=" + csvHeader);
	    Main.datasource.open();
	    try {
 	    	File path = Environment.getExternalStoragePublicDirectory( Environment.DIRECTORY_DOWNLOADS);
 	    	path.mkdir();
 	    	File outFile = new File(path, "/" + outFileName);
 	    	csvHeader += "\n";
 	    	
 	     //   File outFile = new File(outFileName);

	        FileWriter fileWriter = new FileWriter(outFile);
	        BufferedWriter out = new BufferedWriter(fileWriter);
	        Cursor cursor = Main.datasource.findall();
	        if (cursor != null) {
	            out.write(csvHeader);
	            while (cursor.moveToNext()) {
	                csvValues = Long.toString(cursor.getLong(cursor.getColumnIndex(dbOpenHelper.COLUMN_ID))) + ",";
	                csvValues += (cursor.getString(cursor.getColumnIndex(dbOpenHelper.COLUMN_FIRST_NAME)))//first name
	                        + ",";
	                csvValues += (cursor.getString(cursor.getColumnIndex(dbOpenHelper.COLUMN_LAST_NAME)))//last name
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_AGE)))//age 
	                		+ ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_ONE)))//response 1
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_TWO)))//2
	                        + ",";
	                csvValues +=String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_THREE))) //3
	                		+ ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_FOUR)))//4
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_FIVE)))//5
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_SIX)))//6
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_SEVEN)))//7
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_EIGHT)))//8
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_NINE)))//9
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_TEN)))//10
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_ELEVEN)))//11
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_TWELVE)))//12
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_THIRTEEN)))//13
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_FOURTEEN)))//14
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_FIFTEEN)))//15
	                        + ",";
	                csvValues += String.valueOf(cursor.getInt(cursor.getColumnIndex(dbOpenHelper.COLUMN_RESPONSE_SIXTEEN)))//16
	                        + "\n";
	                out.write(csvValues);
	            }
	            cursor.close();
	        }
	        out.close();
	        returnCode = true;
	    } catch (IOException e) {
	        returnCode = false;
	        Log.d(TAG, "IOException: " + e.getMessage());
	    }
	    Main.datasource.close();
	    
	    return returnCode;
	}

}
