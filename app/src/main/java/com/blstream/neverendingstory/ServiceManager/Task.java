package com.blstream.neverendingstory.ServiceManager;

import com.blstream.neverendingstory.Interfaces.ISingleTaskService;
import com.blstream.neverendingstory.Interfaces.ITask;

/**
 * Created by INV-6179 on 17.03.2016.
 */
public class Task implements ITask {
    @Override
    public int getId() {
        return 0;
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
