package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Instructions3 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.training3);
		TextView ourTV3=(TextView)findViewById(R.id.trainingScreen3Text);
		ourTV3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent goNext=new Intent(Instructions3.this,Main.class);
			startActivity(goNext);
				
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
