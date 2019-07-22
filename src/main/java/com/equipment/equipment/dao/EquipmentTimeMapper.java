package com.equipment.equipment.dao;

import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.entity.EquipmentTime;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EquipmentTimeMapper {

    /**
     * 插入数据equipment_time表
     */
    Integer insertDataTime(EquipmentTime equipmentTime);


    /**
     * 查询全部数据
     */
    List<EquipmentTime> selectAll();

    /**
     * 查询表中最后一条数据
     */
    EquipmentTime selectData();

    List<EquipmentTime> getB(EquipmentTime equipment);

//WaterGage
    List<EquipmentTime> getGageDataByCode(EquipmentTime equipment);
    int upshujuA(EquipmentTime equipment);



}
