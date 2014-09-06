package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class Conclude extends Activity {
	Button export2csv;
	Button startAgain;
	//dbDataSource data=new dbDataSource(this);
	//Response mResponse;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.conclude);
		Main.negativeround=0;
		Main.consecutiveCorrect=0;
		Main.totalCorrect=0;
		Main.atfexit=false;
		Main.atfPostiveRound=0;
		 
		Log.i("blablabla", "A new child response  has been created with Child ID "+ Main.rowid);
	export2csv=(Button) findViewById(R.id.exportButton);
	 startAgain=(Button) findViewById(R.id.startAgainButton);
	
	/* export section */
	export2csv.setOnClickListener(new OnClickListener() {
		Boolean databaseClosed=false;
		@Override
		public void onClick(View v) {
			// TODO export database to csv file
			
			if (databaseClosed==false){
			Boolean success=ExportToCSV.backupDatabaseCSV("ChildResponses.csv");
			databaseClosed=true;
			
			
				if(success)
				{Log.i("blablabla","Database Exported to CSV file");
				Toast.makeText(getApplicationContext(), "Database Exported to with file name 'ChildResponses.csv' in downloads directory.", Toast.LENGTH_LONG).show();
				databaseClosed=true;
				}
				else if(success==false)
				{Log.i("blablabla","ZOMBIE ERROORRRR!!! Database could not be Exported to CSV file");
				Toast.makeText(getApplicationContext(), "ZOMBIE ERROORRRR!!! Database could not be Exported to CSV file", Toast.LENGTH_LONG).show();
				}
			}
			else if(databaseClosed==true)
			{
				Toast.makeText(getApplicationContext(),"Database has already been exported to 'Downloads' directory.", Toast.LENGTH_SHORT).show();
			}

			
		}
	}
	
			);
	
// start again button. as data has already been entered so just move to home screen.
	
	  startAgain.setOnClickListener(new OnClickListener() {
	 
		
		@Override
		public void onClick(View v) {
			// TODO start and activity for intent that  just takes us to main.java
			Intent startAgainI=new Intent(Conclude.this, Welcome.class);
			startActivity(startAgainI);
			
		}
	});
	}// on create ends here


}
