package com.lee.testintentservice;

import android.app.IntentService;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyIntentService extends IntentService {

    private static final String TAG = MyIntentService.class.getSimpleName();
    public static final String ACTION_DONE = "Service Done";

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String intentString = intent.getStringExtra("NAME");
        Log.d(TAG, "onHandleIntent: " + intentString);

        for (int i = 0 ; i<5 ; i++){
            SystemClock.sleep(1000);
            Log.d(TAG, "onHandleIntent: start "+ i);
        }
        Log.d(TAG, "onHandleIntent: done");

        Intent intent1 = new Intent();
        intent1.setAction(ACTION_DONE);
        sendBroadcast(intent1);


    }
}
