package com.equipment.equipment.entity;

import java.io.Serializable;
import java.util.List;

public class Arr implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private List<String> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }
}
