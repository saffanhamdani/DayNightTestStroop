package com.exectivefunctiontest.stroop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class Welcome extends Activity implements OnClickListener{
	TextView screenText;
@Override
protected void onCreate(Bundle savedInstanceState) {
	Main.negativeround=0;
	Main.consecutiveCorrect=0;
	Main.totalCorrect=0;
	Main.atfexit=false;
	Main.atfPostiveRound=0;
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	setContentView(R.layout.home1);
	screenText=(TextView)findViewById(R.id.nightCardTV);
	screenText.setOnClickListener(this);
	
}
public void onClick(View v) {
	Intent next=new Intent(Welcome.this, Instructions.class);
	startActivity(next);
}
}
