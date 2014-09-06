package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Assessment16Night extends Activity {
	
	RadioGroup myResponse;
	Button next;
	myCountDownTimer myTimer;
	
	//ContentValues values;
	//ContentValues valuesNeg;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.night);// set content view t designed day 
	// start countDown
	 FragmentManager ourFragManag=getFragmentManager();
	   myTimer = new myCountDownTimer(30000,ourFragManag);
	   myTimer.start();
	//display assessment phase
	TextView ourTV=(TextView)findViewById(R.id.nightCardTV);
	ourTV.setText("Assessment Phase");
	myResponse=(RadioGroup) findViewById(R.id.nightradioGroup);// get reference to radio group
	myResponse.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		 
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub

			switch(checkedId)
			{
			case R.id.nightDay:
			/*	Main.consecutiveCorrect++;
				if(Main.consecutiveCorrect==4)
				{
					//start the assessment
				}
				*/
				Main.totalCorrect++;
				ContentValues values=new ContentValues();
				values.put(dbOpenHelper.COLUMN_RESPONSE_SIXTEEN, 1);
				int rows=Main.datasource.updateRecord(values,(int)Main.rowid);
				Log.i("blablabla", "Response 16 recorded as Positive with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);
						
				break;
			case R.id.nightNet:
				//Main.consecutiveCorrect=0;
				
				ContentValues valuesNeg=new ContentValues();
				valuesNeg.put(dbOpenHelper.COLUMN_RESPONSE_SIXTEEN, 1);
				rows=Main.datasource.updateRecord(valuesNeg,(int)Main.rowid);
				Log.i("blablabla", "Response 16 recorded as Negative with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);			
				
				
				break;				
			
			}		
		}
	});//implement this method
	// move to next screen when next button is pressed
	next=(Button) findViewById(R.id.nightNextButton);
	next.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int responseID=myResponse.getCheckedRadioButtonId();
		if(responseID==-1)
		{
			String DialogMsg=getResources().getString(R.string.empty);
			Intent next2=new Intent(Assessment16Night.this,Conclude.class);
			OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
			Log.i("empty", "Response is empty,passing intent");
			FragmentManager fManager=getFragmentManager();
			myDialog.show(fManager, null);
			
		}
		else{
		// create a new intent and pass to day 2
		Intent nextScreen=new Intent(Assessment16Night.this,Conclude.class);
		startActivity(nextScreen);
	}
	}
});
}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish ();
		Log.i("blablabla", "onStop Called");	
	}
	@Override
	protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	Log.i("blablabla", "onPause Called");	
	myTimer.cancel();
}

}
