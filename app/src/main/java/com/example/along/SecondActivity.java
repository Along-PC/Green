package com.example.along;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SecondActivity extends AppCompatActivity {
    private RingView mRingActivitySecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mRingActivitySecond = (RingView) findViewById(R.id.ring_activity_second);
        mRingActivitySecond.startAnim();
    }
}
