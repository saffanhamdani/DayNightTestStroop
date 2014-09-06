package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Instructions extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.training1);
		TextView outTV=(TextView)findViewById(R.id.trainingScreenFirstText);
		outTV.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
			Intent goNext=new Intent(Instructions.this,Instructions2.class);
			startActivity(goNext);
				
			}
		});
		
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		Log.i("blablabla", "onStop Called");
		finish ();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("blablabla", "onPause Called");
	}
}
