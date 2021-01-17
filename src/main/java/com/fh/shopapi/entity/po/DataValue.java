package com.fh.shopapi.entity.po;

public class DataValue {
    private  Integer id;
    private  String value;
    private  String valueCH;
    private  Integer attId;
    private  Integer isDel;

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValueCH() {
        return valueCH;
    }

    public void setValueCH(String valueCH) {
        this.valueCH = valueCH;
    }

    public Integer getAttId() {
        return attId;
    }

    public void setAttId(Integer attId) {
        this.attId = attId;
    }
}
