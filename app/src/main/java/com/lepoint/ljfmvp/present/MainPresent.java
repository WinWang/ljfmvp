package com.lepoint.ljfmvp.present;

import com.lepoint.ljfmvp.http.HttpUtils;
import com.lepoint.ljfmvp.ui.activity.MainActivity;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * Created by admin on 2018/4/11.
 */

public class MainPresent extends XPresent<MainActivity> {

    public void getHomeData() {
        HttpUtils.getNetData(getV());
    }


}
