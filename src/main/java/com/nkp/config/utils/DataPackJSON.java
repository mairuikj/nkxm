package com.nkp.config.utils;

public class DataPackJSON {
    int flag;  //0成功  1失败
    String msg;
    Object obj;
    int number;

    public int getFlag() {
        return flag;
    }

    public String getMsg() {
        return msg;
    }

    public Object getObj() {
        return obj;
    }

    public int getNumber() {
        return number;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
