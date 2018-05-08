package com.example.along.net;

import android.util.Log;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Title:HttpUtils
 * <p>
 * Description:网络请求工具类
 * </p>
 * Author dragon.
 * Date 2018/4/16 10:32
 */

public class HttpUtils {

    private OkHttpClient mOkHttpClient;


    private HttpUtils(){
        mOkHttpClient=new OkHttpClient.Builder()
                //添加拦截器
//                .addInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return null;
//                    }
//                })
//                .addNetworkInterceptor(new Interceptor() {
//                    @Override
//                    public Response intercept(Chain chain) throws IOException {
//                        return null;
//                    }
//                })
                //连接超时
                .connectTimeout(15,TimeUnit.SECONDS)
                //读取超时
                .readTimeout(20, TimeUnit.SECONDS)
                //写出超时
                .writeTimeout(20,TimeUnit.SECONDS)
                .build();

    }

    //单例获取网络请求对象
    public static HttpUtils getInstance(){
        return Singleton.INSTANCE.getInstance();
    }

    //get访问
    public <T> void get(String url,Map<String,String> requestParams,HttpCallback<T> callback){
        Set<String> keySet = requestParams.keySet();
        Iterator<String> iterator = keySet.iterator();
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(url+"?");
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = requestParams.get(key);
            stringBuffer.append(key+"="+value+"&");
        }
        url=stringBuffer.toString();
        url=url.substring(0,url.length()-1);

        Log.d("request","#######################################################################");
        Log.d("request",url);
        Log.d("request","#######################################################################");

        //创建Request
        Request request = new Request.Builder()
                .url(url)
                .method("GET",null)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }

    //post请求
    public <T> void post(String url,Map<String,String> requestParams,HttpCallback<T> callback){
        Set<String> keySet = requestParams.keySet();
        Iterator<String> iterator = keySet.iterator();
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(url+"?");

        //表单请求体
        FormBody.Builder builder = new FormBody.Builder();
        while (iterator.hasNext()) {
            String key = iterator.next();
            String value = requestParams.get(key);
            stringBuffer.append(key+"="+value+"&");

            builder.add(key,value);
        }
        url=stringBuffer.toString();
        url=url.substring(0,url.length()-1);

        Log.d("request","#######################################################################");
        Log.d("request:",url);
        Log.d("request","#######################################################################");

        RequestBody requestBody = builder.build();

        //创建Request
        Request request = new Request.Builder()
                .url(url)
                .method("POST",requestBody)
                .build();
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);
    }


    //上传文件
    public <T> void upload(String url, Map<String,String> requestParams, String param, File file, HttpCallback<T> callback){
        Set<String> keySet = requestParams.keySet();
        Iterator<String> iterator = keySet.iterator();

        //表单请求体
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        while (iterator.hasNext()) {
            //参数请求体
            String key = iterator.next();
            String value = requestParams.get(key);
            builder.addFormDataPart(key,value);
        }

        Log.d("request","#######################################################################");
        Log.d("request:",url);
        Log.d("request","#######################################################################");

        //文件请求体
        MediaType type=MediaType.parse("application/octet-stream");//"text/xml;charset=utf-8"
        RequestBody fileBody=RequestBody.create(type,file);
        builder.addFormDataPart(param,file.getName(),fileBody);
        MultipartBody requestBody = builder.build();

        //创建Request
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        Call call = mOkHttpClient.newCall(request);
        call.enqueue(callback);

    }


    /**
     * 枚举单列获取请求对象
     */
    private static enum Singleton{
        INSTANCE;

        private HttpUtils mHttpUtils=new HttpUtils();

        private Singleton(){

        }

        public HttpUtils getInstance() {
            return mHttpUtils;
        }
    }


}
