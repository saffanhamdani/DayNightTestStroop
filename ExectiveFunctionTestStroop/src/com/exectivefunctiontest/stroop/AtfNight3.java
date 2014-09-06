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

public class AtfNight3 extends Activity {
	RadioGroup myResponse;
	Button next;
	myCountDownTimer myTimer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.night);
		// start countDown
		FragmentManager fManager=getFragmentManager();
		 myTimer = new myCountDownTimer(30000,fManager);
		
		//display  phase
				TextView ourTV=(TextView)findViewById(R.id.nightCardTV);
				ourTV.setText("Training unsuccessful");
		myResponse=(RadioGroup) findViewById(R.id.nightradioGroup);// get reference to radio group
		myResponse.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub

				switch(checkedId)
				{
				case R.id.nightDay:
					Main.AtfConsecutiveCorrect++;
					Log.i("blablabla", "ATF Response 3 recorded as Positive with Consective Correct Resonses "+Main.consecutiveCorrect);
					break;
					
				case R.id.nightNet:
					Main.AtfConsecutiveCorrect=0;
					Main.atfexit=true;
					Log.i("blablabla", "ATF Response 3 recorded as negative with Consective Correct Resonses "+Main.consecutiveCorrect);
					break;				
				
				}// switch ends here 		
			}// onCheckedChanged ends here
		});//implemented on radio changed method
		
		next=(Button) findViewById(R.id.nightNextButton);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			// create a new intent and pass to day 2
				int responseID=myResponse.getCheckedRadioButtonId();
				if(responseID==-1)
				{
					Intent next2=new Intent(AtfNight3.this,FailedConclude.class);
					String DialogMsg=getResources().getString(R.string.empty);
					OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
					Log.i("empty", "Response is empty,passing intent");
					FragmentManager fManager=getFragmentManager();
					myDialog.show(fManager, null);
					
				}
				else if(Main.atfexit==true)
				{
					//start the main assessment
					Intent startAssesment=new Intent(AtfNight3.this,FailedConclude.class);
					startActivity(startAssesment);
				}
				else 
				{
				Intent nextScreen=new Intent(AtfNight3.this,AtfDay4.class);
				startActivity(nextScreen);
			}
			}
		});
	}// onCreate ends here
	
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
