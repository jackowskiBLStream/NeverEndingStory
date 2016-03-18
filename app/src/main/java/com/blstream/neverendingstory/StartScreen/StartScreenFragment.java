package com.blstream.neverendingstory.StartScreen;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.blstream.neverendingstory.R;
import com.blstream.neverendingstory.ServiceManager.Service;
import com.blstream.neverendingstory.ServiceManager.ServiceManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Damian on 3/17/2016.
 */

public class StartScreenFragment extends Fragment {
    private Spinner spinner;
    private View view;
    private CustomTimeDialog customTimeDialog;
    private ArrayAdapter<String> adapter;
    private Button startButton;
    private ServiceManager manager;
    private int counter;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.start_screen_fragment_layout, container, false);
        manageSpinner();
        startButton = (Button) view.findViewById(R.id.button);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manager.addTask(new Service(counter, 1000));
                        counter++;
            }
        });
        return view;
    }

    public void setServiceManager(ServiceManager manager){
        this.manager = manager;
    }
    public void manageSpinner() {
        final List<String> spinnerArray = new ArrayList<>();
        CustomOnItemSelectedListener customOnItemSelectedListener;

        spinnerArray.add("10 sekund");
        spinnerArray.add("15 sekund");
        spinnerArray.add("20 sekund");
        spinnerArray.add("25 sekund");
        spinnerArray.add("35 sekund");
        spinnerArray.add("Zdefiiniuj wlasny czas....");


        customOnItemSelectedListener = new CustomOnItemSelectedListener(getFragmentManager(), getContext(), spinnerArray);

        spinner = (Spinner) view.findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(customOnItemSelectedListener);

        customOnItemSelectedListener.setiSpinnerHelperListener(new ISpinnerHelperListener() {
            @Override
            public void onAddElementToSpinnerListener() {
                adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, spinnerArray);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(adapter);
                spinner.setSelection(spinnerArray.size() - 2);

            }
        });
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, spinnerArray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

}
