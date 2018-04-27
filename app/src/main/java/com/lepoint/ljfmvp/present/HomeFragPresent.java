package com.lepoint.ljfmvp.present;

import android.content.Context;

import com.alibaba.fastjson.JSONObject;
import com.lepoint.ljfmvp.http.HttpUtils;
import com.lepoint.ljfmvp.http.URLConfig;
import com.lepoint.ljfmvp.ui.fragment.HomeFragment;

/**
 * Created by admin on 2018/4/12.
 */

public class HomeFragPresent extends BasePresent<HomeFragment> {

    public void getNetData(final Context context) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("position", 1);
        HttpUtils.getInstance().getNetData(context, true, jsonObject, URLConfig.BASE_API_URL, URLConfig.QUERYADVERTISMENT, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(String msg) {
                getV().setData(msg);
            }

            @Override
            public void onFailed(Throwable t) {

            }
        });


    }
}
