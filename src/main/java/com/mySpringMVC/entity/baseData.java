package com.mySpringMVC.entity;

public class baseData {
    private boolean success;
    private String msg;
    private Object object;

    public baseData(boolean success, Object object) {
        this.success = success;
        this.msg = Msg(success);
        this.object = object;
    }

    public baseData(boolean success) {
        this.success = success;
        this.msg = Msg(success);
        this.object = null;
    }

    private String Msg(boolean success) {
        if (success) return "成功";
        else return "失败";
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
