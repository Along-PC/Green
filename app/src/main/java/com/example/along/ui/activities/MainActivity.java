package com.example.along.ui.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Environment;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.along.R;
import com.example.along.base.BaseActivity;
import com.example.along.beans.TestBean;
import com.example.along.net.HttpCallback;
import com.example.along.net.HttpUtils;
import com.example.along.views.FlowLayout;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends BaseActivity {
    private FlowLayout mFlowActivityMain;
    private TextView mTvMain;

    @Override
    public void initView(View view) {
        //TODO
        mFlowActivityMain = (FlowLayout) view.findViewById(R.id.flow_activity_main);
        mTvMain = (TextView) view.findViewById(R.id.tv_main);
        mTvMain.setText("猴犀利啊");
        mTvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT > 22) {
                    int i = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (i != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                            Toast.makeText(MainActivity.this, "缺少权限", Toast.LENGTH_SHORT).show();
                        } else {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 10086);
                        }
                    } else {
                        save();
                    }
                } else {
                    save();
                }
            }
        });


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 10086) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                save();
            }
        } else {
            Toast.makeText(this, "用户拒绝授权", Toast.LENGTH_SHORT).show();
        }
    }

    public void save() {
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/along";
        byte[] bytes = "woquni大爷".getBytes();
        File directory = new File(path);
        if (!directory.exists()) {
            directory.mkdir();
        }
        File file = new File(path, "aa.txt");
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(file);
            System.out.println(file.getAbsoluteFile());
            System.out.println("执行了");
            fileOutputStream.write(bytes, 0, bytes.length);
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("along根目录:", Environment.getExternalStorageDirectory().getAbsolutePath());

    }

    @Override
    public void initData() {
        for (int i = 0; i < 30; i++) {
            TextView textView = new TextView(this);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            marginLayoutParams.setMargins(20, 10, 20, 10);
            textView.setText("测试" + i);
            textView.setPadding(15, 5, 15, 5);
            textView.setBackgroundColor(Color.GREEN);
            textView.setLayoutParams(marginLayoutParams);
            mFlowActivityMain.addView(textView);
        }
        System.out.println("ui:" + Process.myTid());


        String url = "http://10.0.2.2:8080/Robot/login";
        Map<String, String> params = new HashMap<>();
        params.put("username", "along");
        params.put("userpwd", "123456");
        HttpUtils.getInstance().get(url, params, new HttpCallback<TestBean>() {
            @Override
            public void onSuccessExecute(TestBean testBean) {
                System.out.println("后边" + Process.myTid());
                System.out.println(testBean.getStatus() + "!!" + testBean.getMsg());
            }
        });
    }

    @Override
    public int getRootView() {
        return R.layout.activity_main;
    }

}
