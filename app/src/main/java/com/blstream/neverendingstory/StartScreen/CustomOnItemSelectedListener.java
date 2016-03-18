package com.blstream.neverendingstory.StartScreen;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Damian on 3/17/2016.
 */

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private FragmentManager fragmentManager;

    public CustomOnItemSelectedListener(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        if(pos == 4){
            showDialogFragment(parent, fragmentManager);
        }

    }

    public void showDialogFragment(AdapterView<?> parent, FragmentManager fragmentManager){
      //  Toast.makeText(parent.getContext(), "YEAH", Toast.LENGTH_SHORT).show();
        CustomTimeDialog dFragment = new CustomTimeDialog();
        // Show DialogFragment
         dFragment.show(fragmentManager, "Dialog Fragment");

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

}