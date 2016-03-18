package com.blstream.neverendingstory.StartScreen;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Damian on 3/17/2016.
 */

public class CustomOnItemSelectedListener implements AdapterView.OnItemSelectedListener {
    private FragmentManager fragmentManager;
    private Context context;
    private List<String> spinnerArray;
    private ISpinnerHelperListener iSpinnerHelperListener;

    public void setiSpinnerHelperListener(ISpinnerHelperListener iSpinnerHelperListener) {
        this.iSpinnerHelperListener = iSpinnerHelperListener;
    }

    public CustomOnItemSelectedListener(FragmentManager fragmentManager, Context context,List<String> spinnerArray) {
        this.fragmentManager = fragmentManager;
        this.context = context;
        this.spinnerArray = spinnerArray;
        iSpinnerHelperListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        //FIXME: code porn ==
        if (parent.getItemAtPosition(pos) == "Zdefiiniuj wlasny czas....") {
            manageDialogFragment(parent, fragmentManager, pos);
        }

    }

    void manageDialogFragment(AdapterView<?> parent, FragmentManager fragmentManager, int pos) {
        final CustomTimeDialog dFragment = new CustomTimeDialog();
        // Show DialogFragment
        dFragment.setiDialogHelperListener(new IDialogHelperListener() {
            @Override
            public void onClickOkButtonListener(float seconds) {
                // Toast.makeText(context, (int) seconds, Toast.LENGTH_SHORT).show();
                spinnerArray.add(spinnerArray.size() - 1, String.valueOf((int) seconds) + " sekund");
                dFragment.dismiss();
                iSpinnerHelperListener.onAddElementToSpinnerListener(seconds);
            }
        });
        dFragment.show(fragmentManager, "Dialog Fragment");

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
    }

}