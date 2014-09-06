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

public class AtfDay1 extends Activity implements OnCheckedChangeListener{
	
	RadioGroup myResponse;
	Button next;
	myCountDownTimer myTimer;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
				// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.day);
		Main.AtfConsecutiveCorrect=0;
		// start countDown
		FragmentManager fManager=getFragmentManager();
		 myTimer = new myCountDownTimer(30000,fManager);
		myResponse=(RadioGroup) findViewById(R.id.answer);// get reference to radio group
	myResponse.setOnCheckedChangeListener(this);//implement this method
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
				Intent next2=new Intent(AtfDay1.this,AtfNight2.class);
				String DialogMsg=getResources().getString(R.string.empty);
				OurDialogClass myDialog=new OurDialogClass(next2,DialogMsg);
				Log.i("empty", "Response is empty,passing intent");
				FragmentManager fManager=getFragmentManager();
				myDialog.show(fManager, null);
				
			}
						
			else if(Main.atfexit==true)
			{
				Intent nextScreen=new Intent(AtfDay1.this,FailedConclude.class);
				Log.i("blablabla", "Failed training, exiting");
				startActivity(nextScreen);	//end assessment here
						}
			else{
				Intent start=new Intent(AtfDay1.this,AtfNight2.class);
				startActivity(start);	
						}
		}// onClick ends here 
	});// onClick listener ends here.
	
	}// on create ends here

	@Override
	public void onCheckedChanged(RadioGroup group, int checkedId) {
		// TODO Auto-generated method stub
		switch(checkedId)
		{
		case R.id.DayRadioButton:
			Main.AtfConsecutiveCorrect=0;
			Main.atfexit=true;
			Log.i("blablabla", "ATF Response 1 recorded as negative with Consective Correct Resonses "+Main.consecutiveCorrect);
			break;
			
		case R.id.NetRadioButton:
			Main.AtfConsecutiveCorrect++;
			Log.i("blablabla", "ATF Response 1 recorded as Positive with Consective Correct Resonses "+Main.consecutiveCorrect);					
			break;
		
		}//switch ends here
		
	}//on checked changed ends here

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
