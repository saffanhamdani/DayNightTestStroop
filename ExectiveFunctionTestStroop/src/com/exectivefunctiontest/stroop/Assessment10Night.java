package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class Assessment10Night extends Activity {
	

	RadioGroup myResponse;
	Button next;
	myCountDownTimer myTimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.night);// set content view t designed day 
	//display assessment phase
			TextView ourTV=(TextView)findViewById(R.id.nightCardTV);
			ourTV.setText("Assessment Phase");
			// start countDown
			 FragmentManager ourFragManag=getFragmentManager();
			   myTimer = new myCountDownTimer(30000,ourFragManag);
			   myTimer.start();
	myResponse=(RadioGroup) findViewById(R.id.nightradioGroup);// get reference to radio group
	myResponse.setOnCheckedChangeListener(new OnCheckedChangeListener() {
		
		 
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			// TODO Auto-generated method stub

			switch(checkedId)
			{
			case R.id.nightDay:
				//Main.consecutiveCorrect=0;
				Main.totalCorrect++;
				ContentValues valuesNeg=new ContentValues();
				valuesNeg.put(dbOpenHelper.COLUMN_RESPONSE_TEN, 1);
				int rows=Main.datasource.updateRecord(valuesNeg,(int)Main.rowid);
				//		Log.i("blablabla", "Response 10 recorded as Negative with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);			
				break;
			case R.id.nightNet:
				
				
				ContentValues values=new ContentValues();
				values.put(dbOpenHelper.COLUMN_RESPONSE_TEN, 0);
				rows=Main.datasource.updateRecord(values,(int)Main.rowid);
				//			Log.i("blablabla", "Response 10 recorded as Positive with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);
				break;				
			
			}		
		}
	});//implement this method
	// move to next screen when next button is pressed
	next=(Button) findViewById(R.id.nightNextButton);
	next.setOnClickListener(new OnClickListener() {
	
	@Override
	public void onClick(View v) {
		int responseID=myResponse.getCheckedRadioButtonId();
		if(responseID==-1)
		{String DialogMsg=getResources().getString(R.string.empty);
			Intent next2=new Intent(Assessment10Night.this,Assessment11Day.class);
			OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
//			Log.i("empty", "Response is empty,passing intent");
			FragmentManager fManager=getFragmentManager();
			myDialog.show(fManager, null);
			
		}
		// TODO Auto-generated method stub
	// create a new intent and pass to day 2
		else
		{
			Intent nextScreen=new Intent(Assessment10Night.this,Assessment11Day.class);
			startActivity(nextScreen);
		}
	}
});
}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		
		finish ();
		myTimer.cancel();
	}

	@Override
	protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	myTimer.cancel();
	}
}
