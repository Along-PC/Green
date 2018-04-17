package com.example.along.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.along.R;

public abstract class BaseActivity extends Activity {

    private LayoutInflater mLayoutInflater;

    //标题栏控件
    private ImageView mImgReturn;
    private TextView mTvTitle;
    private TextView mTvCertain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //去除系统标题栏
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);

        //沉浸式---通知栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        //沉浸式---状态栏
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        mLayoutInflater = this.getLayoutInflater();

        //模板模式完成初始化
        if (isNeedTitle()) {
            LinearLayout linearLayout=new LinearLayout(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            linearLayout.setOrientation(LinearLayout.VERTICAL);
            linearLayout.setLayoutParams(layoutParams);
            View inflateTitle = mLayoutInflater.inflate(R.layout.title_top, linearLayout, false);
            mImgReturn = (ImageView) inflateTitle.findViewById(R.id.img_return);
            mTvTitle = (TextView) inflateTitle.findViewById(R.id.tv_title);
            mTvCertain = (TextView) inflateTitle.findViewById(R.id.tv_certain);
            View inflateContent = mLayoutInflater.inflate(getRootView(), linearLayout, false);
            initView(inflateContent);
            linearLayout.addView(inflateTitle);
            linearLayout.addView(inflateContent);
            setContentView(linearLayout);
        }else{
            setContentView(getRootView());
        }

        initData();

    }

    //初始化控件
    public abstract void initView(View view);

    //初始化数据
    public abstract void initData();

    //获取页面布局
    public abstract int getRootView();

    //是否需要头部标题
    public boolean isNeedTitle(){
        return true;
    }
}
