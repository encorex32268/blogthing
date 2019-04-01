package com.lee.testfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();

    }

    private void findViews() {
        Button newsBtn = findViewById(R.id.newsBtn);
        Button homeBtn = findViewById(R.id.homeBtn);
        newsBtn.setOnClickListener(this);
        homeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.newsBtn:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,NewsFragment.getInstance())
                        .commit();
                break;
            case R.id.homeBtn:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentContainer,HomeFragment.getInstance())
                        .commit();
                break;
        }
    }
}
