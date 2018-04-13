package com.lepoint.ljfmvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import com.lepoint.ljfmvp.R;
import com.lepoint.ljfmvp.present.MainPresent;
import com.lepoint.ljfmvp.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.base.XFragmentAdapter;
import cn.droidlover.xdroidmvp.mvp.XActivity;

public class MainActivity extends XActivity<MainPresent> {


    @BindView(R.id.vp_main_home)
    ViewPager vpMainHome;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public void initData(Bundle savedInstanceState) {
        HomeFragment homeFragment = new HomeFragment();
        fragmentList.add(homeFragment);
        XFragmentAdapter xFragmentAdapter = new XFragmentAdapter(getSupportFragmentManager(), fragmentList, null);
        vpMainHome.setAdapter(xFragmentAdapter);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainPresent newP() {
        return new MainPresent();
    }


}
