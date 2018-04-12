package com.example.along.components.activities;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.along.R;
import com.example.along.base.BaseActivity;
import com.example.along.views.FlowLayout;

public class MainActivity extends BaseActivity {
    private FlowLayout mFlowActivityMain;

    @Override
    public void initView(View view) {
        mFlowActivityMain = (FlowLayout) view.findViewById(R.id.flow_activity_main);
    }

    @Override
    public void initData() {
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

    @Override
    public int getRootView() {
        return R.layout.activity_main;
    }

}
