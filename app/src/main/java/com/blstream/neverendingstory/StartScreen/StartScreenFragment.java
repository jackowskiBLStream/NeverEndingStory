package com.blstream.neverendingstory.StartScreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.blstream.neverendingstory.R;

/**
 * Created by Damian on 3/17/2016.
 */
public class StartScreenFragment extends Fragment  {
    private Spinner spinner;
    private View view;
    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.start_screen_fragment_layout, container, false);
        addListenerOnSpinnerItemSelection();
        return view;
    }



    public void addListenerOnSpinnerItemSelection() {
        spinner = (Spinner)view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener(getFragmentManager()));
    }

}
