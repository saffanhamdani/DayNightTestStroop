package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public class AtfDay4 extends Activity implements OnCheckedChangeListener{
	RadioGroup myResponse;
	Button next;
	myCountDownTimer myTimer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);
		myResponse=(RadioGroup) findViewById(R.id.answer);// get reference to radio group
		myResponse.setOnCheckedChangeListener(this);//implement this method
		// start countDown
		FragmentManager fManager=getFragmentManager();
		 myTimer = new myCountDownTimer(30000,fManager);
		
		//display  phase
		TextView ourTV=(TextView)findViewById(R.id.dayCardTV);
		ourTV.setText("Training unsuccessful");
		
		next=(Button) findViewById(R.id.nextButton);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// create a new intent and pass to day 2
				//start the next screen
				int responseID=myResponse.getCheckedRadioButtonId();
				if(responseID==-1)
				{
					Intent next2=new Intent(AtfDay4.this,AtfDay1.class);
					String DialogMsg=getResources().getString(R.string.empty);
					OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
					Log.i("empty", "Response is empty,passing intent");
					FragmentManager fManager=getFragmentManager();
					myDialog.show(fManager, null);
					
				}
				//Intent start=new Intent(AtfDay4.this,AtfNight2.class);
				//startActivity(start);			
				else if(Main.AtfConsecutiveCorrect==4)
							{
								Main.atfPostiveRound++;
							
							}
				else if(Main.atfPostiveRound == 2)
				{
					Intent gotoAssessement=new Intent(AtfDay4.this,TrainingEnds.class);
					startActivity(gotoAssessement);
				}
				else if(Main.atfexit==true)
					{
						Intent nextScreen=new Intent(AtfDay4.this,FailedConclude.class);
						Log.i("blablabla", "Failed training, exiting");
						startActivity(nextScreen);	//end assessment here
					}
				else{
					Intent nextScrn=new Intent(AtfDay4.this,AtfDay1.class);
					Log.i("blablabla", "Failed training, exiting");
					startActivity(nextScrn);	//goto Atfday1 assessment here
				}
			}// onClick ends here
		});// setOnClick ends here
		
	}// onCreate ends here

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId)
		{
		case R.id.DayRadioButton:
			Main.consecutiveCorrect=0;
			Main.atfexit=false;
			Log.i("blablabla", "ATF Response 4 recorded as negative with Consective Correct Resonses "+Main.consecutiveCorrect);
			break;
			
		case R.id.NetRadioButton:
			Main.consecutiveCorrect++;
			Log.i("blablabla", "ATF Response 4 recorded as Positive with Consective Correct Resonses "+Main.consecutiveCorrect);
			break;
		
		}//switch ends here
	}// onCheckedChanged ends here
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
