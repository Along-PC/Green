package com.example.along;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

public class MainActivity extends AppCompatActivity {
    private FlowLayout mFlowActivityMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFlowActivityMain = (FlowLayout) findViewById(R.id.flow_activity_main);

        for (int i = 0; i < 30; i++) {
            TextView textView = new TextView(this);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            marginLayoutParams.setMargins(20,10,20,10);
            textView.setText("测试"+i);
            textView.setPadding(15,5,15,5);
            textView.setBackgroundColor(Color.GREEN);
            textView.setLayoutParams(marginLayoutParams);
            mFlowActivityMain.addView(textView);
        }
    }

}
