package com.equipment.equipment.service;



import com.equipment.equipment.entity.EquipmentTime;
import com.equipment.equipment.entity.Produce;

import java.util.List;


public interface ProduceService {
    /**
     * 新增
     * @param list
     * @return
     */
    String addAll(List<Produce> list);

    /**
     * 查询全部
     * @return
     */
    List<Produce> getAll();

    /**
     * 查询最后一条数据
     * @return
     */
    Produce getOne();

    List<Produce> getmh(Produce equipment);



    List<Produce> getProduceByCode(Produce produce);
    /**
     * 修改气压
     * @param produce
     * @return
     */
    int upair(Produce produce);
}
