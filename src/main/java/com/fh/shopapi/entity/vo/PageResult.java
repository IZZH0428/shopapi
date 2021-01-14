package com.fh.shopapi.entity.vo;

import java.util.List;

public class PageResult<T> {

    private  int code=200;

    private String msg="处理成功";

    private  Long count;

    private List<T> data;

//  有参构造
    public PageResult(Long count, List<T> data) {
        this.count = count;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
