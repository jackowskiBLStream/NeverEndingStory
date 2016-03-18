package com.blstream.neverendingstory.StartScreen;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.blstream.neverendingstory.R;

/**
 * Created by Damian on 3/17/2016.
 */
public class CustomTimeDialog extends DialogFragment {
    private EditText editText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_time_dialog_layout, container);
        editText = (EditText) view.findViewById(R.id.timeEditText);
        getDialog().setTitle("Hello");

        return view;
    }
}
