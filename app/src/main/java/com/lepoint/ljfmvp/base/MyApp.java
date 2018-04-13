package com.lepoint.ljfmvp.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by admin on 2018/4/12.
 */

public class MyApp extends Application {

    /**
     * 全局的上下文.
     */
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

    }


    /**
     * 获取Context.
     *
     * @return
     */
    public static Context getContext() {
        return mContext;
    }

}
