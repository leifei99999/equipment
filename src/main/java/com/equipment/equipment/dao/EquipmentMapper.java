package com.equipment.equipment.dao;

import com.equipment.equipment.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EquipmentMapper {

    /**
     * 插入数据equipment表
     */
    Integer insertData(Equipment equipment);

    /**
     * 查询全部数据
     */
    List<Equipment> selectAll();

    /**
     * 查询表中最后一条数据
     */
    Equipment selectData();

    /**
     * 模糊查询
     * @return
     */
    List<Equipment> getA(Equipment equipment);


    List<Equipment> getELDataByCode(Equipment equipment);
    /**
     * 修改数据
     * @param equipment
     * @return
     */
    int upshujuA(Equipment equipment);

}
