package com.lee.testbottomnavigation;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //2
        setContentView(R.layout.activity_main_2);
        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Fab click",Toast.LENGTH_SHORT).show();
            }
        });

        //1
       // setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);
        setDefaultView();
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id){

                    case R.id.nav_home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container,HomeFragment.getInstance())
                                .commit();
                        break;
                    case R.id.nav_dasgboard:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container,DashboardFragment.getInstance())
                                .commit();
                        break;
                    case R.id.nav_notify:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container,NotifyFragment.getInstance())
                                .commit();
                        break;
                    case R.id.nav2_home:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container,HomeFragment.getInstance())
                                .commit();
                        break;
                    case R.id.nav2_person:
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.fragment_container,PersonFragment.getInstance())
                                .commit();
                        break;


                }

                return true;
            }
        });
    }

    private void setDefaultView() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container,HomeFragment.getInstance())
                .commit();
    }
}
