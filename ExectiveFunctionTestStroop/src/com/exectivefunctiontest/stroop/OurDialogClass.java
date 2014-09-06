package com.exectivefunctiontest.stroop;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class OurDialogClass extends DialogFragment {
	Intent nextTODO;
	String DisplayText;
	public OurDialogClass(Intent nextScreen, String  message) {
		// TODO Auto-generated constructor stub
		this.nextTODO=nextScreen;
		this.DisplayText=message;
	}

	

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		 AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
	     builder.setMessage(this.DisplayText)
	            .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    startActivity(nextTODO);
	                    Log.i("empty", "Response is empty,continue selected starting next screen.");
	                	
	                }
	            })
	            .setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
	                public void onClick(DialogInterface dialog, int id) {
	                    // User cancelled the dialog
	                }
	            });
	     // Create the AlertDialog object and return it
	     return builder.create();

		//return super.onCreateDialog(savedInstanceState);
	}	
		public static final String TAG="blablabla";


		public void log(String msg)
		{Log.i("blablabla", msg);
		}
		

}
