package com.blstream.neverendingstory.ServiceManager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.blstream.neverendingstory.Interfaces.IService;

/**
 * Created by Patryk Gwiazdowski
 */
public class Service implements IService {
    private int taskID;
    private long taskDuration;
    private ServiceTask mService;
    private boolean mBound;
    private boolean finished;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ServiceTask.LocalBinder binder = (ServiceTask.LocalBinder) service;
            mService = binder.getService();
            System.out.println("Bound!");
            mBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mBound = false;
        }
    };

    public Service(int taskID, long duration) {
        this.taskID = taskID;
        this.taskDuration = duration;
        this.finished = false;
    }

    /**
     * @return task Id
     */
    @Override
    public int getId() {
        return taskID;
    }

    /**
     * @return name to be displayed in Listview
     */
    @Override
    public String getName() {
        return "Operacja przewidziana na " + (taskDuration / 1000) + " sekund";
    }

    /**
     * @return returns task duration
     */
    @Override
    public long getInitialTime() {
        return taskDuration;
    }

    /**
     * Returns task elapsed time.
     * If task has started it return time beetwen 0 and initial time
     * if task has not started it return 0
     * if task has ended it return initialTime
     *
     * @param context android app context
     * @return task elapsed time.
     */
    @Override
    public long getElapsedTime(Context context) {
        if (mService != null) {
            if (mService.getElapsedTime() < taskDuration) {
                return taskDuration;
            } else {
                context.unbindService(mConnection);
                mBound = false;
                finished = true;
                return taskDuration;
            }
        } else
            return 0;
    }

    /**
     * Starts service
     *
     * @return true if service was successfully bounded
     */
    @Override
    public boolean startService(Context context) {
        Intent intent = new Intent(context, ServiceTask.class);
        intent.putExtra("duration", taskDuration);
        mBound = context.bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
        return mBound;
    }

    public boolean isBound() {
        return mBound;
    }
    public boolean isFinished(){
        return finished;
    }
}
