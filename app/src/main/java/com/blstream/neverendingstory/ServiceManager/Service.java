package com.blstream.neverendingstory.ServiceManager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
    private ServiceTask mService;
    private boolean mBound = false;
    private boolean started;
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
    public long getElapsedTime(Context context) {
        if(mService != null){
            if(mService.getElapsedTime() < taskDuration){
                return taskDuration;
            }else{
                context.unbindService(mConnection);
                mBound = false;
                started = false;
                return taskDuration;
            }
        } else
        return 0;
    }

    /**
     * Starts service
     * @return true if service was successfully bounded
     */
    @Override
    public boolean startService(Context context){
        Intent intent = new Intent(context, ServiceTask.class);
        intent.putExtra("duration",taskDuration);
        started = context.bindService(intent, mConnection, context.BIND_AUTO_CREATE);
        return started;
    }
}
