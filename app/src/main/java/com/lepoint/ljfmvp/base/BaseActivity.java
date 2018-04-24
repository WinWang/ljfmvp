package com.lepoint.ljfmvp.base;

import android.os.Bundle;

import cn.droidlover.xdroidmvp.mvp.IPresent;
import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Created by admin on 2018/4/24.
 */

public abstract class BaseActivity<P extends IPresent> extends XActivity<P> {
    @Override
    public void initData(Bundle savedInstanceState) {

    }


    @Override
    public P newP() {
        return null;
    }


}
