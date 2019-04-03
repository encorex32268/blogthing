package com.lee.testintentservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentFilter = new IntentFilter(MyIntentService.ACTION_DONE);
        registerReceiver(receiver,intentFilter);


    }
    public void startIntentService(View v){
        Intent intent = new Intent(this,MyIntentService.class);
        intent.putExtra("NAME","T1");
        startService(intent);
        intent.putExtra("NAME","T2");
        startService(intent);
        intent.putExtra("NAME","T3");
        startService(intent);
    }

    BroadcastReceiver receiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "onReceive: "+intent.getAction());
        }
    };
}
