package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class TrialFailed extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		Main.negativeround=0;
		Main.consecutiveCorrect=0;
		Main.totalCorrect=0;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.trainingfailed);
		Main.atfPostiveRound=0;
		Main.atfexit=false;
		Main.AtfConsecutiveCorrect=0;
		TextView failedTV=(TextView)findViewById(R.id.trainingfailedTV);
		failedTV.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				Intent afterFailedTrail=new Intent(TrialFailed.this,AtfDay1.class);
				startActivity(afterFailedTrail);
			}
		});

	
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish ();
	}

}
