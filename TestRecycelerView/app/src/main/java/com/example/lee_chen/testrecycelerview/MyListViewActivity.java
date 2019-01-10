package com.example.lee_chen.testrecycelerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MyListViewActivity extends AppCompatActivity {

    private ArrayList<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list_view);


        datas = new ArrayList<>();
        for (int i =1 ; i<51 ; i++)
        {
            datas.add("User : "+i);
        }

        ListView mlistView = findViewById(R.id.mlistView);
        mlistView.setAdapter(new mListViewAdapter(this));
    }

    private class mListViewAdapter extends ArrayAdapter{

        public mListViewAdapter(Context context) {
            super(context,android.R.layout.simple_list_item_1);
        }

        @Override
        public int getCount() {
            return datas.size();
        }
        @Override
        public Object getItem(int position) {
            return getItem(position);
        }

        @Override
        public int getPosition(Object item) {
            return super.getPosition(item);
        }

        @Override
        public long getItemId(int position) {
            return getItemId(position);
        }
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder viewHolder;
            if (convertView == null)
            {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.custom_listview_row,parent,false);
                viewHolder = new ViewHolder();
                viewHolder.mListButton = convertView.findViewById(R.id.mListButton);
                viewHolder.mListTextView = convertView.findViewById(R.id.mListTextView);
                convertView.setTag(viewHolder);
            }else
            {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.mListTextView.setText(datas.get(position));
            viewHolder.mListButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),"This is "+datas.get(position),Toast.LENGTH_SHORT).show();
                }
            });
            return convertView;
    }

        class ViewHolder{
            TextView mListTextView;
            Button mListButton;
        }
    }
}
