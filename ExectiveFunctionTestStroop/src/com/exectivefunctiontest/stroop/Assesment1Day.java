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

public class Assesment1Day extends Activity implements OnCheckedChangeListener {


	RadioGroup myResponse;
	Button next;
	myCountDownTimer myTimer;
long time=30000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);// set content view t designed day 
		myResponse=(RadioGroup) findViewById(R.id.answer);// get reference to radio group
		TextView ourTV=(TextView)findViewById(R.id.dayCardTV);
		ourTV.setText("Assessment Phase");
		// start countDown
		FragmentManager ourFragManager= getFragmentManager();
		 myTimer= new myCountDownTimer(time,ourFragManager);
		  myTimer.start();
		
		myResponse.setOnCheckedChangeListener(this);//implement this method
	// move to next screen when next button is pressed
		next=(Button) findViewById(R.id.nextButton);
		//TextView ourTView=(TextView)findViewById(R.id.assesmentStartText);
		//ourTView.setText(Main.Assessment);
	next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			int responseID=myResponse.getCheckedRadioButtonId();
			if(responseID==-1)
			{
				Intent next2=new Intent(Assesment1Day.this,Assessment2Night.class);
				String DialogMsg=getResources().getString(R.string.empty);
				OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
//				Log.i("empty", "Response is empty,passing intent");
				FragmentManager fManager=getFragmentManager();
				myDialog.show(fManager, null);
				
			}
			// TODO Auto-generated method stub
		// create a new intent and pass to day 2
			else{Intent nextScreen=new Intent(Assesment1Day.this,Assessment2Night.class);
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
			//Main.consecutiveCorrect=0;
			ContentValues valuesNeg=new ContentValues();
			valuesNeg.put(dbOpenHelper.COLUMN_RESPONSE_ONE, 0);
			int rows=Main.datasource.updateRecord(valuesNeg,(int)Main.rowid);
			//	Log.i("blablabla", "Response 1 recorded as Negative with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);			
			
			break;
		case R.id.NetRadioButton:
			Main.totalCorrect++;
			ContentValues values=new ContentValues();
			values.put(dbOpenHelper.COLUMN_RESPONSE_ONE, 1);
			rows=Main.datasource.updateRecord(values,(int)Main.rowid);
			//		Log.i("blablabla", "Response 1 recorded as Positive with row id as "+Main.rowid+" NUMBER OF ROWS AFFECTED = "+rows);
			
			break;
		
		}
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	
		Main.datasource.close();
		finish ();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		myTimer.cancel();
	}
}
