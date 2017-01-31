package org.bts.android.dummyservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class CustomStartedService extends Service {

    private static final String TAG = CustomStartedService.class.getSimpleName();

    public CustomStartedService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.w(CustomStartedService.TAG, "In-onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        waitForSomeTime(5);


        Log.w(CustomStartedService.TAG, "In-onStartCommand()");
        return Service.START_NOT_STICKY;
    }

    public static void waitForSomeTime (int timeInSeconds) {

        long endTime = System.currentTimeMillis() + timeInSeconds * 1000;

        while (System.currentTimeMillis() < endTime ) {
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
