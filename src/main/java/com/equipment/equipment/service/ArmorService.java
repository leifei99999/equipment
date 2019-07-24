package com.equipment.equipment.service;

import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.service.exception.InsertException;
import com.equipment.equipment.service.exception.UpdateException;

import java.util.List;

public interface ArmorService {



    /**
     * 插入数据users表
     */
    void addUsers(Armor users) throws InsertException;

    /**
     * 查询全部数据
     */
    List<Armor> listUsers(Armor armor);

    /**
     * 查询表中最后一条数据
     */
    Armor usersData(Armor armor);

    /**
     * 修改状态信息
     */
    void usersState(String id, int state)throws UpdateException;

    /**
     * 上传维修记录图片信息
     */
  /*  Armor upRecordImages(Armor armor) throws UpdateException;
*/
    /**
     * 修改维修信息
     */
    void upInsert(Armor armor);

    /**
     * 模糊查询
     * @param armor
     * @return
     */

     List<Armor> getm(Armor armor);

     List<Armor> getF(Armor armor);

     List<Armor> selecid(Armor armor);

    List<Armor> getDataByCode(Armor armor);

}
