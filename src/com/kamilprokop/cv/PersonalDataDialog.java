package com.kamilprokop.cv;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class PersonalDataDialog extends DialogFragment
{
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState)
	{
		return new AlertDialog.Builder(getActivity())
				.setTitle(R.string.personal_data)
				.setMessage(R.string.personal_details)
				.setPositiveButton(R.string.close, null).create();
	}
}
