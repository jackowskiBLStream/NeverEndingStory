package com.blstream.neverendingstory.MainManager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blstream.neverendingstory.R;

/**
 * Created by blstream on 3/17/2016.
 */
public class StartScreenFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.start_screen_fragment_layout, container, false);
    }
}
