package org.bts.android.dummyservice;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions and extra parameters.
 */
public class CustomIntentService extends IntentService {

    private static final String TAG = CustomIntentService.class.getSimpleName();

    public CustomIntentService() {
        super(null);

    }

    @Override
    protected void onHandleIntent(Intent intent) {

        CustomStartedService.waitForSomeTime(5);
        Log.w(CustomIntentService.TAG, "In-onHandleIntent()");


    }
}
