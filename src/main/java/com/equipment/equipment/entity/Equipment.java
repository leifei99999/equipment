package com.equipment.equipment.entity;

import java.util.Date;

public class Equipment {

    private String id ;
    private String equipmentName ;
    private String brand ;
    private String model ;
    private String codeNo;
    private String manufactureTime ;
    private String shelfLife ;
    private String supplierName ;
    private String afterSales ;
    private String detectionTime ;
    private  String detectionDate ;
    private  String qualified ;
    private Integer image;
    private ServicePic servicePic;//图片类对象
    private String nowtime;

    public String getNowtime() {
        return nowtime;
    }

    public void setNowtime(String nowtime) {
        this.nowtime = nowtime;
    }

    public ServicePic getServicePic() {
        return servicePic;
    }

    public void setServicePic(ServicePic servicePic) {
        this.servicePic = servicePic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getManufactureTime() {
        return manufactureTime;
    }

    public void setManufactureTime(String manufactureTime) {
        this.manufactureTime = manufactureTime;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getAfterSales() {
        return afterSales;
    }

    public void setAfterSales(String afterSales) {
        this.afterSales = afterSales;
    }

    public String getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(String detectionTime) {
        this.detectionTime = detectionTime;
    }

    public String getDetectionDate() {
        return detectionDate;
    }

    public void setDetectionDate(String detectionDate) {
        this.detectionDate = detectionDate;
    }

    public String getQualified() {
        return qualified;
    }

    public void setQualified(String qualified) {
        this.qualified = qualified;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", equipmentName='" + equipmentName + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", manufactureTime=" + manufactureTime +
                ", shelfLife='" + shelfLife + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", afterSales='" + afterSales + '\'' +
                ", detectionTime=" + detectionTime +
                ", detectionDate='" + detectionDate + '\'' +
                ", qualified='" + qualified + '\'' +
                '}';
    }
}
