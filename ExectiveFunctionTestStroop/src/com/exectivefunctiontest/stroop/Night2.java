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
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class Night2 extends Activity {
	RadioGroup myResponse;
	Button next;
	CountDownTimer myTimer;
	
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.night);// set content view t designed day 
	TextView outTV=(TextView)findViewById(R.id.nightCardTV);
	outTV.setText("Training Phase");
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
				Main.consecutiveCorrect++;
				Log.i("blablabla", "Response 2 recorded as Positive with Consective Correct Resonses "+Main.consecutiveCorrect);			
				break;						

			case R.id.nightNet:
				Main.consecutiveCorrect=0;
				Log.i("blablabla", "Response 2 recorded as negative with Consective Correct Resonses "+Main.consecutiveCorrect);
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
	// create a new intent and pass to day 2
		int responseID=myResponse.getCheckedRadioButtonId();
		
		if(responseID==-1)
		{
			Intent next2=new Intent(Night2.this,Night3.class);
			String DialogMsg=getResources().getString(R.string.empty);
			OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
			Log.i("empty", "Response is empty,passing intent");
			FragmentManager fManager=getFragmentManager();
			myDialog.show(fManager, null);
		}
			
		else if(Main.consecutiveCorrect>=4)
		{
			//start the main assessment
			Toast.makeText(getApplicationContext(), "Training successfully completed", Toast.LENGTH_SHORT).show();
			//start the main assessment
			Intent startAssesment=new Intent(Night2.this,TrainingEnds.class);
			startActivity(startAssesment);
		
		}
		
		else if (Main.negativeround<4 && Main.consecutiveCorrect<4)
		{
		Intent nextScreen=new Intent(Night2.this,Night3.class);
		startActivity(nextScreen);
		}
	}//onClicklistener ends here
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