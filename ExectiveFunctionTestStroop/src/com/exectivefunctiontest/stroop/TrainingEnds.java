package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TrainingEnds extends Activity {
	Button startAssessmentButton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		Main.negativeround=0;
		Main.consecutiveCorrect=0;
		Main.totalCorrect=0;
		Main.atfexit=false;
		Main.atfPostiveRound=0;
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.startassessment);
		startAssessmentButton=new Button(this);
		startAssessmentButton=(Button)findViewById(R.id.startAssessmentButton);
	startAssessmentButton.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
		Intent startAssessment=new Intent(TrainingEnds.this,Assesment1Day.class);	
		startActivity(startAssessment);
		}
	});
	
	}//on create ends here
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish ();
	}
}//class ends here
