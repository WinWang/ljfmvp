package com.lepoint.ljfmvp.http;

import android.content.Context;

import cn.droidlover.xdroidmvp.net.XApi;

/**
 * Created by admin on 2018/4/11.
 */

public class HttpUtils {

    public static final String BASE_URL = "http://appjk.lep365.com"; //登录注册服务地址


    private static ApiService apiService;

    public static ApiService getGankService(String BASE_URL) {
        if (apiService == null) {
            synchronized (HttpUtils.class) {
                if (apiService == null) {
                    apiService = XApi.getInstance().getRetrofit(BASE_URL+"/", true).create(ApiService.class);
                }
            }
        }
        return apiService;
    }

    public static void getNetData(Context context) {
        System.out.println("我在测试");

    }


}
