package com.lepoint.ljfmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.View;

import com.lepoint.ljfmvp.R;
import com.lepoint.ljfmvp.utils.AppManager;
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
        AppManager.getAppManager().addActivity(this);
        initTopBar();

    }

    @Override
    protected void initTopBar() {
        topBar = (QMUITopBar) findViewById(R.id.qm_topbar);
        if (topBar != null) {
            topBar.setBackgroundColor(ContextCompat.getColor(this, R.color.x_yellow));
            if (isShowBack()) {
                topBar.addLeftBackImageButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AppManager.getAppManager().finishActivity(BaseActivity.this);
                    }
                });

            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }

    protected boolean isShowBack() {
        return true;
    }


}
