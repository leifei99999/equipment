package com.equipment.equipment.dao;

import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.entity.EquipmentTime;
import com.equipment.equipment.entity.Produce;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProduceDao {
    /**
     * 新增
     * @param
     * @return
     */
    int addOne(Produce pd);

    /**
     * 查询全部
     * @return
     */

    List<Produce> getAll();

    /**
     * 查询最后一条
     * @return
     */
    Produce getLast();

    List<Produce> getC(Produce equipment);

    List<Produce> getProduceByCode(Produce produce);

    /**
     * 修改气压
     * @param produce
     * @return
     */
    int upair(Produce produce);
}
