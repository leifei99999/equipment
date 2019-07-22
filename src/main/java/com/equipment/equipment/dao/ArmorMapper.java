package com.equipment.equipment.dao;

import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ArmorMapper {

    /**
     * 插入数据users表
     */
    Integer insertData(Armor armor);

    /**
     * 查询全部数据
     */
    List<Armor> selectAll(Armor armor);
    /**
     * 查询全部数据
     */
    List<Armor> select(Armor armor);

    /**
     * 查询表中最后一条数据
     */
    Armor selectDa(Armor armor);
    /**
     * 查询表中最后一条数据
     */
    Armor selectData(Armor armor);


    /**
     * 修改状态信息
     */
    Integer updateState(@Param("id") String id,@Param("state") int state);

    /**
     * 修改维修信息
     */
    Integer addInsert(Armor armor);

    /**
     * 维修模糊
     * @param equipment
     * @return
     */
    List<Armor> getD(Armor equipment);

    /**
     * 清洗模糊
     * @param equipment
     * @return
     */
    List<Armor> getE(Armor equipment);


    List<Armor> getF(Armor armor);

    /**
     * 根据id查
     * @param armor
     * @return
     */
    List<Armor> selecid(Armor armor);

    List<Armor> getDataByCode(Armor armor);

}
