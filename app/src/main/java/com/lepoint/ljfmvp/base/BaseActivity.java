package com.lepoint.ljfmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.lepoint.ljfmvp.R;
import com.qmuiteam.qmui.widget.QMUITopBar;

import cn.droidlover.xdroidmvp.mvp.IPresent;
import cn.droidlover.xdroidmvp.mvp.XActivity;

/**
 * Created by admin on 2018/4/24.
 */

public abstract class BaseActivity<P extends IPresent> extends XActivity<P> {


    protected QMUITopBar topBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        initTopBar();

    }

    @Override
    protected void initTopBar() {
        topBar = (QMUITopBar) findViewById(R.id.qm_topbar);
        if (topBar != null) {
            topBar.setBackgroundColor(ContextCompat.getColor(this, R.color.x_yellow));
            topBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }

}
