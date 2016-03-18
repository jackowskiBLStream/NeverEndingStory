package com.blstream.neverendingstory.StartScreen;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.blstream.neverendingstory.R;

/**
 * Created by Damian on 3/17/2016.
 */
public class CustomTimeDialog extends DialogFragment {
    private Button button;
    private EditText editText;
    private IDialogHelperListener iDialogHelperListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.custom_time_dialog_layout, container);
        button = (Button) view.findViewById(R.id.okButton);
        editText = (EditText) view.findViewById(R.id.timeEditText);
        getDialog().setTitle("Hello");

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //wailidacja

                if (s != null) {
                    //zablokuje button i wyswietl error
                    editText.setError("blad");
                }
                else {

                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   float seconds = Float.parseFloat(editText.getText().toString());
                    if (isNumberIntegerAndGreaterThanZero(seconds)) {
                        iDialogHelperListener.onClickOkButtonListener(seconds);
                    } else {
                        Toast.makeText(getContext(), "Liczba musi byc calkowita i dodatnia!", Toast.LENGTH_SHORT).show();
                    }



            }
        });
        return view;
    }


    public boolean isNumberIntegerAndGreaterThanZero(float seconds) {
        return seconds == (int) seconds && seconds > 0;
    }

    public boolean isNumberProperlySeparatedByDot(String textFromEditText) {
        String pattern = "([-+]?[0-9]*/.?[0-9]+)";
        return textFromEditText.matches(pattern);
    }

    public void setiDialogHelperListener(IDialogHelperListener iDialogHelperListener) {
        this.iDialogHelperListener = iDialogHelperListener;
    }
}
