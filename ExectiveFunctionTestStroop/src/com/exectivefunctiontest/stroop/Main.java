package com.exectivefunctiontest.stroop;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main extends Activity {
	public static dbDataSource datasource;
	public static long rowid;
	public static boolean showTimerDialog=false;
	public static int  consecutiveCorrect=0;
	public static int negativeround=0;
	public static int totalCorrect=0;
	public static String Training="Phase One: Training";
	public static String Assessment="Phase Two: Assessment";
	public static boolean atfexit=false;
	static int atfPostiveRound=0;
	
	 int iAge;
	//public Response ChildResponse=new Response();
	private static final String LOGTAG = "EXPLORECA";
	 static int AtfConsecutiveCorrect = 0;
	public static boolean radiogroupEmpty=false;
	String fName;
	String lName;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.home); 
	//	log("reached 1");
		
//	log("reached 20");
	final EditText firstName=(EditText) findViewById(R.id.firstName);
//	log("reached 30");
	final EditText lastName=(EditText) findViewById(R.id.lastName);
//	log("reached 40");
	final EditText age=(EditText) findViewById(R.id.age);
//	log("reached 50");
	
	
	//create a new data source with given name age and then add it to database
	
	Button start=(Button) findViewById(R.id.startButton);
//	log("reached 60");

	datasource=new dbDataSource(Main.this);
	
	
	start.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if(TextUtils.isEmpty(firstName.getText().toString()))
				Toast.makeText(getApplicationContext(), "Please Enter First Name", Toast.LENGTH_SHORT).show();
			if(TextUtils.isEmpty(lastName.getText().toString()))
				Toast.makeText(getApplicationContext(), "Please Enter Last Name", Toast.LENGTH_SHORT).show();
	//			log("reached 70");
				if(TextUtils.isEmpty(lastName.getText().toString())==false && TextUtils.isEmpty(firstName.getText().toString())==false)
				{rowid=datasource.recordNameAge(firstName.getText().toString(),lastName.getText().toString(),Integer.parseInt((age.getText().toString())));
			log("New record created with row id"+rowid);
			
			Intent startTest=new Intent(Main.this,Day1.class);
			// TODO Auto-generated method stub
			startActivity(startTest);
				}
		}
	});
	

	}// on create ends

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		//finish();
		//datasource.close();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		datasource.open();
	}
public void log(String msg){
	Log.i(LOGTAG, msg);
}
@Override
protected void onStop() {
	// TODO Auto-generated method stub
	super.onStop();
	finish ();
}
}
