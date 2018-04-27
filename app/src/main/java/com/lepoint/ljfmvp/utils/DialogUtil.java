package com.lepoint.ljfmvp.utils;

import android.content.Context;

import com.qmuiteam.qmui.widget.dialog.QMUITipDialog;

/**
 * Created by admin on 2018/3/23.
 */

public class DialogUtil {


    /**
     * DialogUtil实例
     */
    private static DialogUtil INSTANCE;
    private QMUITipDialog tipDialog;


    /**
     * 获取DialogUtil实例 ,单例模式
     */
    public static DialogUtil getInstance() {
        if (INSTANCE == null) {
            synchronized (DialogUtil.class) {
                if (INSTANCE == null) {
                    INSTANCE = new DialogUtil();
                }
            }
        }
        return INSTANCE;
    }


    public QMUITipDialog showDialog(Context context) {
        if (tipDialog == null) {
            tipDialog = new QMUITipDialog.Builder(context)
                    .setTipWord("加载中")
                    .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                    .create();
            tipDialog.show();
            tipDialog.setCancelable(true);
        } else {
            try {
                tipDialog.show();
            } catch (Exception e) { //防止dialog中上下文重复存在，直接重新创建
                tipDialog = new QMUITipDialog.Builder(context)
                        .setTipWord("加载中")
                        .setIconType(QMUITipDialog.Builder.ICON_TYPE_LOADING)
                        .create();
                tipDialog.show();
                tipDialog.setCancelable(true);
            }
        }
        return tipDialog;
    }


    public void cancleDialog() {
        if (tipDialog != null) {
            try {
                tipDialog.dismiss(); //防止context导致错误
            } catch (Exception e) {

            }
        }
    }


}
