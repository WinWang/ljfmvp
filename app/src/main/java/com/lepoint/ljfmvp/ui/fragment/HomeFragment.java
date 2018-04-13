package com.lepoint.ljfmvp.ui.fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.lepoint.ljfmvp.R;
import com.lepoint.ljfmvp.present.HomeFragPresent;

import butterknife.BindView;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

/**
 * Created by admin on 2018/4/12.
 */

public class HomeFragment extends XLazyFragment<HomeFragPresent> {
    @BindView(R.id.tv_home_frag)
    TextView tvHomeFrag;

    @Override
    public void initData(Bundle savedInstanceState) {
        getP().getNetData(context);
    }

    public void setData(String text) {
        tvHomeFrag.setText(text);
    }

    @Override
    public int getLayoutId() {
        return R.layout.frag_home_layout;
    }

    @Override
    public HomeFragPresent newP() {
        return new HomeFragPresent();
    }

}
