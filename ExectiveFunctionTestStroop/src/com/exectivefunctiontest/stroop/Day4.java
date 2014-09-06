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
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class Day4 extends Activity {
	RadioGroup myResponse;
	Button next;
	Toast trainingEndsToast;
	CountDownTimer myTimer;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);// set content view t designed day 
		myResponse=new RadioGroup(this);
		next=new Button(this);
		myResponse=(RadioGroup) findViewById(R.id.answer);
		// start countDown
		FragmentManager ourFragManag=getFragmentManager();
		   myTimer = new myCountDownTimer(30000,ourFragManag);
		   myTimer.start();
		TextView ourTV=(TextView)findViewById(R.id.dayCardTV);
		ourTV.setText("Training Phase");
		
		myResponse.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch(checkedId)
				{
				case R.id.DayRadioButton:
					Main.consecutiveCorrect=0;
					Main.negativeround++;
					Log.i("blablabla", "Response 4 recorded as negative with Consective Correct Resonses "+Main.consecutiveCorrect);
					break;
					
				case R.id.NetRadioButton:
					Main.consecutiveCorrect++;
					Log.i("blablabla", "Response 4 recorded as Positive with Consective Correct Resonses "+Main.consecutiveCorrect);
					break;
				
				}
	
			}
		});//implement this method
	// move to next screen when next button is pressed
		Log.i("blablabla", "Reached 90");
		next=(Button) findViewById(R.id.nextButton);
		Log.i("blablabla", "Reached 100");
	next.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		// create a new intent and pass to day 2
			Log.i("blablabla", "Reached 110");
			int responseID=myResponse.getCheckedRadioButtonId();
			
			if(responseID==-1)
			{
				
				 if (Main.negativeround<4 && Main.consecutiveCorrect<4)
				{
					Intent next2=new Intent(Day4.this,Day1.class);
					Log.i("blablabla", "Running again from day1");
					String DialogMsg=getResources().getString(R.string.empty);
					OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
					Log.i("empty", "Response is empty,passing intent");
					FragmentManager fManager=getFragmentManager();
					myDialog.show(fManager, null);
				}
			}// if nothing is selected portion ends here
			else if(Main.consecutiveCorrect==4)
			{
				Toast.makeText(getApplicationContext(), "Training successfully completed", Toast.LENGTH_SHORT).show();
				//start the main assessment
				Intent startAssesment=new Intent(Day4.this,TrainingEnds.class);
				startActivity(startAssesment);
			
			}
			else if(Main.negativeround>=4)
			{
				Intent nextScreen=new Intent(Day4.this,Conclude.class);
				Log.i("blablabla", "Training Failed, exiting");
			
				Toast.makeText(getApplicationContext(), "Training failed", Toast.LENGTH_SHORT).show();
				startActivity(nextScreen);	//end assessment here
			}
			else if (Main.negativeround<4 && Main.consecutiveCorrect<4)
			{
				Intent nextScreen=new Intent(Day4.this,Day1.class);
				Log.i("blablabla", "Running again from day1");
				startActivity(nextScreen);	//start next round assessment here
			}
			
		}
	});
		
		
	}
	//**** radio group selection ***.//
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
