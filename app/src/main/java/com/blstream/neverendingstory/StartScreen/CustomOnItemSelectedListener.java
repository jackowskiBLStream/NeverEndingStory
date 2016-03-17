package com.blstream.neverendingstory.StartScreen;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

/**
 * Created by Damian on 3/17/2016.
 */

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

    public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
        if(pos == 4){
            showDialogFragment(parent);
        }
    }

    public void showDialogFragment(AdapterView<?> parent){
        Toast.makeText(parent.getContext(), "YEAH", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

}