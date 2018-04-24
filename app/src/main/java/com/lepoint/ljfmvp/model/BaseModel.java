package com.lepoint.ljfmvp.model;

import cn.droidlover.xdroidmvp.net.IModel;

/**
 * Created by admin on 2018/4/23.
 */

public class BaseModel implements IModel {

    private String message;
    private int resultCode;


    @Override
    public boolean isNull() {
        return false;
    }

    @Override
    public boolean isAuthError() {
        return resultCode == -1;
    }

    @Override
    public boolean isBizError() {
        return false;
    }

    @Override
    public String getErrorMsg() {
        return null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }
}
