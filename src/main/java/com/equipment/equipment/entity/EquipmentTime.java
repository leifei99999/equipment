package com.equipment.equipment.entity;

import java.util.Date;

public class EquipmentTime {

    private String id ;
    private String codeNo;

    private String equipmentName ;
    private String brand ;
    private String model ;
    private String manufactureTime ;
    private  String shelfLife ;
    private String supplierName ;
    private String afterSales ;
    private String detectionTime ;
    private  String detectionDate ;
    private  String qualified ;
    private String nextTestTime;

    public String getNextTestTime() {
        return nextTestTime;
    }

    public void setNextTestTime(String nextTestTime) {
        this.nextTestTime = nextTestTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
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

    @Override
    public String toString() {
        return "EquipmentTime{" +
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
                ", nextTestTime='" + nextTestTime + '\'' +
                '}';
    }
}
