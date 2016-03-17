package com.blstream.neverendingstory.ServiceManager;

import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.widget.Toast;

/**
 * Created by Patryk Gwiazdowski
 * Service class that runs in background and performs task in specified time
 */
public class ServiceTask extends android.app.Service {
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
    private Handler handler = new Handler();

    private final IBinder mBinder = new LocalBinder();

    public class LocalBinder extends Binder {
        ServiceTask getService() {
            //zwracamy instancje serwisu, przez nią odwołamy się następnie do metod.
            return ServiceTask.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    //metoda którą zapewniamy.
    public void generateToast() {
        handler.post(new Runnable() {
            public void run() {
                Toast.makeText(getApplicationContext(), "WITAJ W SERWISIE(znowu)", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

