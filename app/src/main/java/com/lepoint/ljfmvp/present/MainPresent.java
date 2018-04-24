package com.lepoint.ljfmvp.present;

import com.google.gson.Gson;
import com.lepoint.ljfmvp.http.HttpUtils;
import com.lepoint.ljfmvp.http.URLConfig;
import com.lepoint.ljfmvp.model.BannerBean;
import com.lepoint.ljfmvp.ui.activity.MainActivity;
import com.lepoint.ljfmvp.utils.SpUtils;
import com.lepoint.ljfmvp.utils.StringUtils;

import cn.droidlover.xdroidmvp.net.ApiSubscriber;
import cn.droidlover.xdroidmvp.net.NetError;
import cn.droidlover.xdroidmvp.net.XApi;

/**
 * Created by admin on 2018/4/11.
 */

public class MainPresent extends BasePresent<MainActivity> {

    public void getHomeData() {
        //        HttpUtils.getGankService(URLConfig.BASE_API_URL).getToken("1", "111")
        //                .compose(XApi.<TokenBean>getApiTransformer())
        //                .compose(XApi.<TokenBean>getScheduler())
        //                .subscribe(new ApiSubscriber<TokenBean>() {
        //                    @Override
        //                    protected void onFail(NetError error) {
        //
        //                    }
        //
        //                    @Override
        //                    public void onNext(TokenBean baseModel) {
        //                        if (baseModel.isAuthError()) {  //权限验证错误，token过期
        //                            getToken();
        //                        }
        //                    }
        //                });

        Gson gson = new Gson();
        String s = gson.toJson("{}");
        String token = SpUtils.getString(getV(), "token", "accessToken");
        String key = SpUtils.getString(getV(), "token", "secretKey");
        long timeStamp = System.currentTimeMillis();
        String sign = StringUtils.encryptToSHA(token + URLConfig.QUERYADVERTISMENT + json.toJSONString() + timeStamp + key);
        HttpUtils.getGankService(URLConfig.BASE_API_URL).queryHomeData(token, key, s, System.currentTimeMillis(), "", "")
                .compose(XApi.<BannerBean>getApiTransformer())
                .compose(XApi.<BannerBean>getScheduler())
                .subscribe(new ApiSubscriber<BannerBean>() {
                    @Override
                    protected void onFail(NetError error) {
                        if (error.getType() == 2) { //数据验证异常
                            getToken();
                        }
                    }

                    @Override
                    public void onNext(BannerBean baseModel) {
                        if (baseModel.isAuthError()) {  //权限验证错误，token过期
                            System.out.println("请求token");
                            getToken();
                            getV().showData(baseModel);
                        }


                        System.out.println(">>>>>>>"+baseModel.getMessage());

                    }
                });


    }


}
