package com.spsz.zrodo.njspsz.Utils;

import android.support.annotation.Nullable;

import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
//
//测试账户： 出证：18118673613 123456 索证：18618435258 123456
public class Http_Util {
    public static void sendpostRequest(String url, RequestBody body, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        client.newCall(request).enqueue(callback);
    }

    public static void sendgetRequest(String url,Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(callback);
    }
}
