package com.equipment.equipment.entity;

public class Produce {
    private String id;
    private String codeNo;
    private String data;
    private String time;
    private String inflatingWater;//加压排水量
    private String reducedWater;//卸压排水量
    private String deformation;//残余变形率
    private String state;//合格/不合格
    private String detectionNo;//检测号
    private String outNo;//出厂号
    private String productNo;//产品号
    private String experimenter;//实验人员
    private String operator;//操作员
    private String air;


    public String getCodeNo() {
        return codeNo;
    }

    public void setCodeNo(String codeNo) {
        this.codeNo = codeNo;
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getData() {
        return this.data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getInflatingWater() {
        return inflatingWater;
    }

    public void setInflatingWater(String inflatingWater) {
        this.inflatingWater = inflatingWater;
    }

    public String getReducedWater() {
        return reducedWater;
    }

    public void setReducedWater(String reducedWater) {
        this.reducedWater = reducedWater;
    }

    public String getDeformation() {
        return this.deformation;
    }

    public void setDeformation(String deformation) {
        this.deformation = deformation;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDetectionNo() {
        return this.detectionNo;
    }

    public void setDetectionNo(String detectionNo) {
        this.detectionNo = detectionNo;
    }

    public String getOutNo() {
        return this.outNo;
    }

    public void setOutNo(String outNo) {
        this.outNo = outNo;
    }

    public String getProductNo() {
        return this.productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getExperimenter() {
        return this.experimenter;
    }

    public void setExperimenter(String experimenter) {
        this.experimenter = experimenter;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
