package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class Day1 extends Activity implements OnCheckedChangeListener {
	RadioGroup myResponse;
	Button next;
	CountDownTimer myTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);// set content view t designed day 
		TextView ourTV=(TextView)findViewById(R.id.dayCardTV);
		ourTV.setText("Training Phase");
		myResponse=(RadioGroup) findViewById(R.id.answer);// get reference to radio group
		// start countDown
		 FragmentManager ourFragManag=getFragmentManager();
		   myTimer = new myCountDownTimer(30000,ourFragManag);
		   myTimer.start();
		myResponse.setOnCheckedChangeListener(this);//implement this method
	
		// move to next screen when next button is pressed
		next=(Button) findViewById(R.id.nextButton);
		
	next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		// create a new intent and pass to day 2
			int responseID=myResponse.getCheckedRadioButtonId();
			
			if(responseID==-1)
			{
				Intent next2=new Intent(Day1.this,Night2.class);
				String DialogMsg=getResources().getString(R.string.empty);
				OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
				Log.i("empty", "Response is empty,passing intent");
				FragmentManager fManager=getFragmentManager();
				myDialog.show(fManager, null);	
			}
			else if(Main.consecutiveCorrect==4)
			{
				Toast.makeText(getApplicationContext(), "Training successfully completed", Toast.LENGTH_SHORT).show();
				//start the main assessment
				Intent startAssesment=new Intent(Day1.this,TrainingEnds.class);
				startActivity(startAssesment);
			
			}
			
			else 
			{
			Intent nextScreen=new Intent(Day1.this,Night2.class);
			startActivity(nextScreen);
			}
			}
	});
		
	
		
	}// onCreate ends here
	//**** radio group selection ***.//
	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		Log.i("empty", "Deafult id is"+checkedId);
		switch(checkedId)
		{
		case R.id.DayRadioButton:
			Main.consecutiveCorrect=0;
			Main.radiogroupEmpty=false;
			Log.i("blablabla", "Response 1 recorded as negative with Consective Correct Resonses "+Main.consecutiveCorrect);
			
					
			break;
		case R.id.NetRadioButton:
			Main.consecutiveCorrect++;
			Main.radiogroupEmpty=false;
			
			Log.i("blablabla", "Response 1 recorded as Positive with Consective Correct Resonses "+Main.consecutiveCorrect);
			
			
			break;
		case -1:
			Main.radiogroupEmpty=true;
			Log.i("empty", "Response is empty");
		break;
		}
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		//Main.datasource.close();
		finish ();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		myTimer.cancel();
	}
}
