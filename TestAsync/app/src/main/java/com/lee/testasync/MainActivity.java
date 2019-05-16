package com.lee.testasync;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String link = "https://tw.yahoo.com/";
        new YahooTask().execute(link);

    }

    class YahooTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            Log.d(TAG, "doInBackground: "+strings[0]);
            StringBuilder stringBuilder = null;
            try {
                URL url = new URL(strings[0]);
                InputStream in = url.openStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                String line = br.readLine();
                stringBuilder = new StringBuilder();
                while (line != null) {
                    Log.d(TAG, "doInBackground: "+line);
                    stringBuilder.append(line);
                    line = br.readLine();
                    publishProgress(10);
                }
                publishProgress(100);
                //Log.d(TAG, "onCreate: "+stringBuilder.toString());
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(stringBuilder.length()==0)return "without data";
            return stringBuilder.toString();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.d(TAG, "onProgressUpdate: "+values[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d(TAG, "onPostExecute: "+s);
        }
    }
}
