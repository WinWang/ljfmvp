package com.lepoint.ljfmvp.ui.fragment;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.lepoint.ljfmvp.R;
import com.lepoint.ljfmvp.present.HomeFragPresent;
import com.lepoint.ljfmvp.utils.ToastUtil;

import butterknife.BindView;
import butterknife.OnClick;
import cn.droidlover.xdroidmvp.mvp.XLazyFragment;

/**
 * Created by admin on 2018/4/12.
 */

public class HomeFragment extends XLazyFragment<HomeFragPresent> {
    @BindView(R.id.tv_home_frag)
    TextView tvHomeFrag;
    @BindView(R.id.btn_home_frag_text)
    Button btnHomeFragText;

    @Override
    public void initData(Bundle savedInstanceState) {
        getP().getNetData(context);
    }

    public void setData(String text) {
        tvHomeFrag.setText(text);
        ToastUtil.showToast(context, text);
    }

    @Override
    public int getLayoutId() {
        return R.layout.frag_home_layout;
    }

    @Override
    public HomeFragPresent newP() {
        return new HomeFragPresent();
    }


    @OnClick(R.id.btn_home_frag_text)
    public void onViewClicked() {
        getP().getNetData(context);
    }
}
