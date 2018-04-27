package com.lepoint.ljfmvp.ui.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Button;

import com.lepoint.ljfmvp.R;
import com.lepoint.ljfmvp.base.BaseActivity;
import com.lepoint.ljfmvp.model.BannerBean;
import com.lepoint.ljfmvp.model.TokenBean;
import com.lepoint.ljfmvp.present.MainPresent;
import com.lepoint.ljfmvp.ui.fragment.HomeFragment;
import com.qmuiteam.qmui.widget.QMUITopBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.base.XFragmentAdapter;

public class MainActivity extends BaseActivity<MainPresent> {


    @BindView(R.id.vp_main_home)
    ViewPager vpMainHome;
    @BindView(R.id.buttonPanel)
    Button buttonPanel;
    @BindView(R.id.qm_topbar)
    QMUITopBar qmTopbar;
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public void initData(Bundle savedInstanceState) {
        HomeFragment homeFragment = new HomeFragment();
        fragmentList.add(homeFragment);
        XFragmentAdapter xFragmentAdapter = new XFragmentAdapter(getSupportFragmentManager(), fragmentList, null);
        vpMainHome.setAdapter(xFragmentAdapter);
        //        getP().getHomeData();
        qmTopbar.setTitle("首页");

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    public MainPresent newP() {
        return new MainPresent();
    }


    public void showData(TokenBean tokenBean) {

    }

    public void showData(BannerBean tokenBean) {

    }


    @OnClick(R.id.buttonPanel)
    public void onViewClicked() {
        getP().getHomeData();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
