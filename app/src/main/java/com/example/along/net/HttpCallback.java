package com.example.along.net;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;

import com.google.gson.Gson;
import com.orhanobut.logger.Logger;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Title:
 * <p>
 * Description:
 * </p>
 * Author dragon.
 * Date 2018/4/16 11:29
 */

public abstract class HttpCallback<T>  implements Callback{

    private Handler mHandler=new Handler(Looper.getMainLooper());

    @Override
    public void onFailure(Call call, IOException e) {
        Log.d("onFailure","#######################################################################");
        Log.d("onFailure",e.getMessage());
        Log.d("onFailure","#######################################################################");
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        if (response.isSuccessful()) {
            Log.d("onResponse","#######################################################################");
            String responseText = response.body().string();
            Log.d("onResponse",responseText);
            Logger.json(responseText);
            Log.d("onResponse","#######################################################################");

            Gson gson = new Gson();
            //获取泛型的class对象
            Class <T> entityClass = (Class <T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            final T t = gson.fromJson(responseText, entityClass);

            System.out.println("前边"+ Process.myTid());
            mHandler.post(new Runnable() {
                @Override
                public void run() {
                    onSuccessExecute(t);
                }
            });
        }else{
            Log.d("onResponse","#######################################################################");
            Log.d("onResponse","响应码："+response.code()+"响应信息："+response.message());
            Log.d("onResponse","#######################################################################");
        }
    }

    public abstract void onSuccessExecute( T t);
}
