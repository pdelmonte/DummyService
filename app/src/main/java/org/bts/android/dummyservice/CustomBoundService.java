package org.bts.android.dummyservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.util.Random;

public class CustomBoundService extends Service {

    private static final String TAG = CustomBoundService.class.getSimpleName();
    private IBinder mBinder = new Binder();

    public CustomBoundService() {
        Log.w(CustomBoundService.TAG, "Bound Service empty constructor.");

    }

    public CustomBoundService(IBinder serviceInfo) {
        Log.w(CustomBoundService.TAG, "Bound Service non-empty constructor.");

        this.mBinder = serviceInfo;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.w(CustomBoundService.TAG, "In-onCreate...");
    }

    @Override
    public IBinder onBind(Intent intent) {

        Log.w(CustomBoundService.TAG, "In-onBind");
        return this.mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {

        Log.w(CustomBoundService.TAG, "In-onUnbind");
        return super.onUnbind(intent);
    }

    public int getRandomNumber() {
        Random randomGenerator = new Random();
        int num = randomGenerator.nextInt();
        return num;
    }
}
