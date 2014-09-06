package com.exectivefunctiontest.stroop;

import android.app.FragmentManager;
import android.os.CountDownTimer;
import android.util.Log;

public class myCountDownTimer extends CountDownTimer {
	static long interval=1000;
	FragmentManager fragManager;
public myCountDownTimer(long startTime, FragmentManager myfmanger) {
	   super(startTime, interval);
	   this.fragManager=myfmanger;
	  }
	 

	 
	  @Override
	  public void onTick(long millisUntilFinished) {
	   //text.setText("" + millisUntilFinished / 1000);
		  Log.i("timer", millisUntilFinished/1000+" seconds remaining");
	  }

	@Override
	public void onFinish() {
		// TODO Auto-generated method stub
		Log.i("timer","Timer up. onFinish() Called.");
		showOurDialog();
		
	}
	
	public void showOurDialog()
{myDialogClass myDialog=new myDialogClass("Child has not given response in 30 seconds.");
myDialog.show(fragManager, null);
	}
	
	
}
