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

public class Assessment7Day extends Activity implements OnCheckedChangeListener {
	

	RadioGroup myResponse;
	Button next;
	myCountDownTimer myTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);// set content view t designed day 
		// start countDown
		FragmentManager fManager=getFragmentManager();
		 myTimer = new myCountDownTimer(30000,fManager);
		
		myResponse=(RadioGroup) findViewById(R.id.answer);// get reference to radio group
		myResponse.setOnCheckedChangeListener(this);//implement this method
		//display assessment phase
				TextView ourTV=(TextView)findViewById(R.id.dayCardTV);
				ourTV.setText("Assessment Phase");
		// move to next screen when next button is pressed
		next=(Button) findViewById(R.id.nextButton);
	next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int responseID=myResponse.getCheckedRadioButtonId();
			if(responseID==-1)
			{
				String DialogMsg=getResources().getString(R.string.empty);
				Intent next2=new Intent(Assessment7Day.this,Assessment8Night.class);
				OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
				Log.i("empty", "Response is empty,passing intent");
				FragmentManager fManager=getFragmentManager();
				myDialog.show(fManager, null);
				
			}
			else{
			// create a new intent and pass to day 2
			Intent nextScreen=new Intent(Assessment7Day.this,Assessment8Night.class);
			startActivity(nextScreen);
		}
	}
	});
		
		
	}
	//**** radio group selection ***.//
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId)
		{
		case R.id.DayRadioButton:
			ContentValues valuesNeg=new ContentValues();
			valuesNeg.put(dbOpenHelper.COLUMN_RESPONSE_SEVEN, 0);
			int rows=Main.datasource.updateRecord(valuesNeg,(int)Main.rowid);
			Log.i("blablabla", "Response 7 recorded as Negative with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);			
							
			break;
		case R.id.NetRadioButton:
			Main.totalCorrect++;
			ContentValues values=new ContentValues();
			values.put(dbOpenHelper.COLUMN_RESPONSE_SEVEN, 1);
			rows=Main.datasource.updateRecord(values,(int)Main.rowid);
			Log.i("blablabla", "Response 7 recorded as Positive with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);

			//Main.consecutiveCorrect=0;
			
			break;
		
		}
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish ();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	myTimer.cancel();
	}	

}
