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
    private int taskID;
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
            mBound=false;
        }
    };

    public Service(int taskID,long duration) {

    }

    @Override
    public int getId() {
        return taskID;
    }

    @Override
    public String getName() {
        return null;
    }

    /**
     * @return
     */
    @Override
    public long getInitialTime() {
        return 0;
    }

    @Override
    public long getElapsedTime() {
        return 0;
    }

    @Override
    public ISingleTaskService getService() {
        return null;
    }
}
