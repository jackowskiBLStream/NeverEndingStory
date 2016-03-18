package com.blstream.neverendingstory.MainManager;

/**
 * Created by Damian on 3/17/2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.blstream.neverendingstory.Class.TaskPreviewFragment;
import com.blstream.neverendingstory.ServiceManager.ServiceManager;
import com.blstream.neverendingstory.StartScreen.StartScreenFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private int mNumOfTabs;
    private TaskPreviewFragment taskPreviewFragment;
    private StartScreenFragment startScreenFragment;
    private ServiceManager manager;
    public SectionsPagerAdapter(FragmentManager fm, int NumOfTabs,ServiceManager manager) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
        this.manager = manager;
        this.taskPreviewFragment = new TaskPreviewFragment();
        this.startScreenFragment = new StartScreenFragment();
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                StartScreenFragment tab1 = startScreenFragment;
                return tab1;
            case 1:
                TaskPreviewFragment task = taskPreviewFragment;
                return task;
            default:
                return null;
        }
    }
    public StartScreenFragment getStartScreenFragment(){
        return this.startScreenFragment;
    }
    @Override
    public int getCount() {
        // Show 3 total pages.
        return mNumOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "SECTION 1";
            case 1:
                return "SECTION 2";
            case 2:
                return "SECTION 3";
        }
        return null;
    }

    public TaskPreviewFragment getTaskPreviewFragment(){
        return this.taskPreviewFragment;
    }
}
