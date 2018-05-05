package com.lepoint.ljfmvp.ui.activity;

import android.os.Bundle;

import com.alibaba.fastjson.JSONObject;
import com.lepoint.ljfmvp.R;
import com.lepoint.ljfmvp.base.BaseActivity;
import com.lepoint.ljfmvp.http.HttpUtils;
import com.lepoint.ljfmvp.http.URLConfig;

public class TestActivity extends BaseActivity {


    @Override
    public void initData(Bundle savedInstanceState) {
        topBar.setTitle("测试界面");
        JSONObject json = new JSONObject();
        json.put("position", 3);
        HttpUtils.getInstance().getNetData(context, true, json, URLConfig.BASE_API_URL, URLConfig.QUERYADVERTISMENT, new HttpUtils.NetCallBack() {
            @Override
            public void onSuccess(String msg) {

            }

            @Override
            public void onFailed(Throwable t) {

            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_test;
    }

    @Override
    public Object newP() {
        return null;
    }
}
