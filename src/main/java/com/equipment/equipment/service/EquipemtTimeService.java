package com.equipment.equipment.service;

import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.entity.EquipmentTime;
import com.equipment.equipment.service.exception.InsertException;

import java.util.List;

public interface EquipemtTimeService {

    /**
     * 插入数据equipment_time表
     */
    void addDataTime(EquipmentTime equipmentTime) throws InsertException;

    /**
     * 查询全部数据
     */
    List<EquipmentTime> listEquipmentTime();

    /**
     * 查询表中最后一条数据
     */
    EquipmentTime equipmenTimetData();

    List<EquipmentTime> getmh(EquipmentTime equipment);

    int upshujuA(EquipmentTime equipment);

    List<EquipmentTime> getDataByCode(EquipmentTime equipment);
}
