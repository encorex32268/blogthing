package com.example.lee_chen.testrecycelerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button listViewButton = findViewById(R.id.listViewButton);
        Button recyclerButton = findViewById(R.id.recyclerButton);
        listViewButton.setOnClickListener(this);
        recyclerButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        if (v.getId()==R.id.listViewButton)
        {
            intent.setClass(MainActivity.this,MyListViewActivity.class);

        }else if (v.getId()==R.id.recyclerButton)
        {
            intent.setClass(MainActivity.this,MyRecycelerViewActivity.class);
        }
        startActivity(intent);
    }
}
