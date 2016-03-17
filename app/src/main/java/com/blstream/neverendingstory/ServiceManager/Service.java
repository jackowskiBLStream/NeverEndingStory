package com.blstream.neverendingstory.ServiceManager;

import com.blstream.neverendingstory.Interfaces.ISingleTaskService;
import com.blstream.neverendingstory.Interfaces.IService;

/**
 * Created by INV-6179 on 17.03.2016.
 */
public class Service implements IService {
    private int taskID;

    public Service(){

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
