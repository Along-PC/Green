package com.example.along.ui.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.along.R;
import com.example.along.ui.adapters.GridAdapter;
import com.example.along.ui.adapters.ListAdapter;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {
    private TextView mTv1;
    private TextView mTv2;
    private TextView mTv3;
    private TextView mTv4;
    private GridView mGridActivityTest;
    private GridAdapter mGridAdapter;
    private ListView mListActivityTest;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mTv1 = (TextView) findViewById(R.id.tv_1);
        mTv2 = (TextView) findViewById(R.id.tv_2);
        mTv3 = (TextView) findViewById(R.id.tv_3);
        mTv4 = (TextView) findViewById(R.id.tv_4);
        mGridActivityTest = (GridView)findViewById(R.id.grid_activity_test);
        mListActivityTest = (ListView) findViewById(R.id.list_activity_test);

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            strings.add("aaaaaaaa");
        }
        mGridAdapter = new GridAdapter(this, strings);
        mGridActivityTest.setAdapter(mGridAdapter);
        mListAdapter = new ListAdapter(this, strings);
        mListActivityTest.setAdapter(mListAdapter);


        mTv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(Intent.ACTION_VIEW);

                Uri uri = Uri.parse("https://www.zydsoft.cn/jlxx/008.mp4");
                it.setDataAndType(uri, "video/mp4");
                startActivity(it);
            }
        });
        mTv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> strings = new ArrayList<>();
                for (int i = 0; i < 30; i++) {
                    strings.add("bbbbbb");
                }
                mGridAdapter.setStrings(strings);
                mListAdapter.setStrings(strings);
            }
        });
        mTv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> strings = new ArrayList<>();
                for (int i = 0; i < 6; i++) {
                    strings.add("ccccccc");
                }
                mGridAdapter.setStrings(strings);
                mListAdapter.setStrings(strings);
            }
        });
        mTv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<String> strings = new ArrayList<>();
                for (int i = 0; i < 30; i++) {
                    strings.add("dddddd");
                }
                mGridAdapter.setStrings(strings);
                mListAdapter.setStrings(strings);
            }
        });

    }
}
