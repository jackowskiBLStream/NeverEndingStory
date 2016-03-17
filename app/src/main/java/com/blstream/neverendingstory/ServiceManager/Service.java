package com.blstream.neverendingstory.ServiceManager;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

import com.blstream.neverendingstory.Interfaces.ISingleTaskService;
import com.blstream.neverendingstory.Interfaces.IService;

/**
 * Created by Patryk Gwiazdowski
 */
public class Service implements IService {
    private ServiceTask serviceTask;
    private int taskID;
    private long taskDuration;
    protected ServiceTask mService;
    protected boolean mBound = false;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            ServiceTask.LocalBinder binder = (ServiceTask.LocalBinder) service;
            mService = binder.getService();
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
        serviceTask = new ServiceTask();
    }

    @Override
    public int getId() {
        return taskID;
    }

    @Override
    public String getName() {
        return "Operacja przewidziana na "+(taskDuration/1000)+" sekund";
    }

    /**
     * @return returns task duration
     */
    @Override
    public long getInitialTime() {
        return taskDuration;
    }

    @Override
    public long getElapsedTime() {
        return mService.getElapsedTime();
    }

    @Override
    public ISingleTaskService getService() {
        return mService;
    }
}
