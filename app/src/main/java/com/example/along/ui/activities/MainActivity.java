package com.example.along.ui.activities;

import android.graphics.Color;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.along.R;
import com.example.along.base.BaseActivity;
import com.example.along.beans.TestBean;
import com.example.along.net.HttpCallback;
import com.example.along.net.HttpUtils;
import com.example.along.views.FlowLayout;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private FlowLayout mFlowActivityMain;
    private TextView mTvMain;

    @Override
    public void initView(View view) {
        mFlowActivityMain = (FlowLayout) view.findViewById(R.id.flow_activity_main);
        mTvMain = (TextView) view.findViewById(R.id.tv_main);
        mTvMain.setText("猴犀利啊");
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
        System.out.println("ui:"+Process.myTid());


        String url="http://10.0.2.2:8080/Robot/login";
        Map<String,String> params=new HashMap<>();
        params.put("username","along");
        params.put("userpwd","123456");
        HttpUtils.getInstance().get(url, params, new HttpCallback<TestBean>() {
            @Override
            public void onSuccessExecute(TestBean testBean) {
                System.out.println("后边"+Process.myTid());
                System.out.println(testBean.getStatus()+"!!"+testBean.getMsg());
            }
        });
    }

    @Override
    public int getRootView() {
        return R.layout.activity_main;
    }

}
