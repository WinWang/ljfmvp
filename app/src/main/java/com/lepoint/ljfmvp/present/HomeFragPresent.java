package com.lepoint.ljfmvp.present;

import android.content.Context;

import com.lepoint.ljfmvp.ui.fragment.HomeFragment;

import cn.droidlover.xdroidmvp.mvp.XPresent;

/**
 * Created by admin on 2018/4/12.
 */

public class HomeFragPresent extends XPresent<HomeFragment> {
    public void getNetData(Context context){
        getV().setData("wo zia ce shi ");
    }
}
