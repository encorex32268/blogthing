package com.example.lee_chen.testrecycelerview;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyRecycelerViewActivity extends AppCompatActivity {

    private ArrayList<String>  fruit = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_recyceler_view);

        String[] fruits = new String[]{
                "apple","avocado","banana","cherry","coconut",
                "jujube","durian","grape","guava","durian","grapefruit","honeydew melon",
                "lemon","lichee","orange","kiwi","mangosteen","papaya","pear","persimmon","pineapple"
        };
        for(String temp :fruits)
        {
            fruit.add(temp);
        }

        RecyclerView mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(new mAdatper());
    }

    class mAdatper extends RecyclerView.Adapter<mAdatper.ViewHolder>{

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.custom_recyclerview_row,viewGroup,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
                viewHolder.textView.setText(""+fruit.get(i));
                viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked)
                        Toast.makeText(MyRecycelerViewActivity.this,"Buy : "+fruit.get(i),Toast.LENGTH_SHORT).show();
                    }
                });
        }

        @Override
        public int getItemCount() {
            if (null==fruit)
                return 0;
            return fruit.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder{

            TextView textView;
            CheckBox checkBox;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.recyclertextView);
                checkBox = itemView.findViewById(R.id.recyclercheckBox);
            }
        }
    }
}
