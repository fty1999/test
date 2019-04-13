package com.bawei.com.test.model.http;

import android.os.AsyncTask;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Auther: 樊腾亚
 * @Date: 2019/4/13 08:30:13
 * @Description:
 */
public class AsyncHttpClient {
    public static final AsyncHttpClient ourInstance = new AsyncHttpClient();
    public static final String TAG = "AsyncHttpClient";

    public static AsyncHttpClient getInstance(){
        return ourInstance;
    }
    public void GetAsync(String server_url,final AsyncCallBack callBack){
        //异步处理
        new AsyncTask<String,Void,String>(){

            @Override
            protected String doInBackground(String... strings) {
                return GetDataHttp(strings[0]);
            }

            @Override
            protected void onPostExecute(String s) {
                if (!TextUtils.isEmpty(s)){
                    callBack.Succorce(s);
                }else {
                    callBack.Error(503,"未请求到数据");
                }
            }
        }.execute(server_url);
    }

    //获取网络数据
    private String GetDataHttp(String server_url){
        try {
            URL url = new URL(server_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);
            InputStream stream = connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder builder = new StringBuilder();
            String str="";
            while ((str=reader.readLine())!=null){
                builder.append(str);
            }
            connection.disconnect();
            return builder.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    //创建一个接口
    public interface AsyncCallBack{
        void Error(int errorcode,String message);
        void Succorce(String result);
    }
}
