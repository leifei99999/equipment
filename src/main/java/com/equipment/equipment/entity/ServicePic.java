package com.equipment.equipment.entity;

import java.util.List;

public class ServicePic {
    Integer reid;//图片id 自增
    String img;//图片名字
    List<String> data;//接收base64用

    public Integer getReid() {
        return reid;
    }

    public void setReid(Integer reid) {
        this.reid = reid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
