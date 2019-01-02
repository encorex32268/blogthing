package com.example.lee_chen.customview;

import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //main layout id
        ConstraintLayout constraintLayout = findViewById(R.id.mainLayout);
        View custom_view = LayoutInflater.from(this).inflate(R.layout.custom_view,constraintLayout,false);
        constraintLayout.addView(custom_view);
        Button customViewButton = custom_view.findViewById(R.id.customViewButton);
        customViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"hey im customButton",Toast.LENGTH_SHORT) .show();
            }
        });


        final CustomTextView customTextView = findViewById(R.id.customTextView);
        final CountDownTimer countDownTimer = new CountDownTimer(4000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long second = millisUntilFinished/1000;
                if (second==3)
                {
                    customTextView.setText("3");
                }else if (second==2){
                    customTextView.setText("2");
                }else if (second==1)
                {
                    customTextView.setText("1");
                }

            }

            @Override
            public void onFinish() {
                customTextView.setText("0");
            }
        };

        customTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countDownTimer.start();
            }
        });



    }


}
