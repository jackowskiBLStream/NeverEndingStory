package com.blstream.neverendingstory.ServiceManager;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.blstream.neverendingstory.Interfaces.ISingleTaskService;

/**
 * Created by Patryk Gwiazdowski
 * Service class that runs in background and performs task in specified time
 */
public class ServiceTask extends android.app.Service implements ISingleTaskService {

    /**
     * @return return service instance. With it you can use methods
     */
    public class LocalBinder extends Binder {
        ServiceTask getService() {
            return ServiceTask.this;
        }
    }

    private final IBinder mBinder = new LocalBinder();
    private ElapsedTimeHolder elapsedTimeHolder;
    private long elapsedTime;
    private Runnable thread;

    /**
     * @return task elapsed time in milis
     */
    public synchronized long getElapsedTime() {

        return elapsedTime;

    }


    /**
     * Return the communication channel to the service.  May return null if
     * clients can not bind to the service.  The returned
     * {@link IBinder} is usually for a complex interface
     * that has been <a href="{@docRoot}guide/components/aidl.html">described using
     * aidl</a>.
     * <p/>
     * <p><em>Note that unlike other application components, calls on to the
     * IBinder interface returned here may not happen on the main thread
     * of the process</em>.  More information about the main thread can be found in
     * <a href="{@docRoot}guide/topics/fundamentals/processes-and-threads.html">Processes and
     * Threads</a>.</p>
     *
     * param intent The Intent that was used to bind to this service,
     *               as given to {@link Context#bindService
     *               Context.bindService}.  Note that any extras that were included with
     *               the Intent at that point will <em>not</em> be seen here.
     * return Return an IBinder through which clients can call on to the
     * service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        long duration = intent.getLongExtra("duration",0);
        thread = new Thread(new ServiceThread(duration));
        thread.run();
        return mBinder;
    }

}

