package com.hxinternet.hxtalk.http.api.bean.base;

import java.io.Serializable;

/**
 * create time: 2021/1/19
 * author: wd
 * description:
 */
public class BaseBean extends BaseNoEmptyBean implements Serializable {

    protected String status;

    protected String msg;

    protected String ok;

    public String getStatus() {
        return retString(status);
    }

    public String getMsg() {
        return retString(msg);
    }

    public String getOk() {
        return retString(ok);
    }

    public DataBean data;



}
