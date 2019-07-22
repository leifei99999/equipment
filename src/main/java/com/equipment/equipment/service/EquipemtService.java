package com.equipment.equipment.service;

import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.service.exception.InsertException;

import java.util.List;

public interface EquipemtService {



    /**
     * 插入数据equipment表
     */
    void addData(Equipment equipment) throws InsertException;

    /**
     * 查询全部数据
     */
    List<Equipment> listEquipment();

    /**
     * 查询表中最后一条数据
     */
    Equipment equipmentData();

    public List<Equipment> getmh(Equipment equipment);

    int upshujuA(Equipment equipment);

  List<Equipment> getDataByCode(Equipment equipment);

}
