package com.equipment.equipment.entity;


import java.util.List;

public class Armor {

    private String id ;
    private String codeNo;
    private String username; //姓名
    private String affiliationcOmpany ; //所属中队
    private String bloodType; //血型
    private String brand; //品牌
    private String model; //型号
    private String manufactureTime; //生产日期
    private int state; //状态    :默认  1:出库   2:入库
    private int rinseService; //清洗维修   0:清洗   1:维修
    private Integer recordImage;  //维修记录图片对应图片表id
    private ServicePic servicePic;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAffiliationcOmpany() {
        return affiliationcOmpany;
    }

    public void setAffiliationcOmpany(String affiliationcOmpany) {
        this.affiliationcOmpany = affiliationcOmpany;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getRinseService() {
        return rinseService;
    }

    public void setRinseService(int rinseService) {
        this.rinseService = rinseService;
    }

    public Integer getRecordImage() {
        return recordImage;
    }

    public void setRecordImage(Integer recordImage) {
        this.recordImage = recordImage;
    }

    public ServicePic getServicePic() {
        return servicePic;
    }

    public void setServicePic(ServicePic servicePic) {
        this.servicePic = servicePic;
    }
}
