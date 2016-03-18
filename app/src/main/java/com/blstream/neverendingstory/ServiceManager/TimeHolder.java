package com.blstream.neverendingstory.ServiceManager;

/**
 * Created by Patryk Gwiazdowski on 17.03.2016.
 * class to hold and synchronize elapsed time
 */
public class TimeHolder {
    private long elapsedTime;

    public TimeHolder(){
        elapsedTime=0;
    }
    public synchronized long getElapsedTime() {
        return elapsedTime;
    }

    public synchronized void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
    }
}
