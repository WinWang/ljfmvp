package com.lepoint.ljfmvp.present;

import android.content.Context;

import com.lepoint.ljfmvp.http.HttpUtils;
import com.lepoint.ljfmvp.http.URLConfig;
import com.lepoint.ljfmvp.model.TokenBean;
import com.lepoint.ljfmvp.utils.SpUtils;

import cn.droidlover.xdroidmvp.mvp.IView;
import cn.droidlover.xdroidmvp.mvp.XPresent;
import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;

/**
 * Created by admin on 2018/4/24.
 */

public  class BasePresent<V extends IView> extends XPresent<V> {

    public void getToken() {
        HttpUtils.getGankService(URLConfig.BASE_API_URL).getToken("1", "111")
                .compose(XApi.<TokenBean>getApiTransformer())
                .compose(XApi.<TokenBean>getScheduler())
                .subscribe(new ApiSubscriber<TokenBean>() {
                    @Override
                    protected void onFail(NetError error) {

                    }

                    @Override
                    public void onNext(TokenBean baseModel) {
                        if (getV() instanceof Context) {
                            SpUtils.setString((Context)getV(), "token", "accessToken", baseModel.getAccessToken());
                            SpUtils.setString((Context)getV(), "token", "secretKey", baseModel.getSecretKey());
                        }
                    }
                });
    }




}
