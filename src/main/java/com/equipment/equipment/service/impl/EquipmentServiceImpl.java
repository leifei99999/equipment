package com.equipment.equipment.service.impl;

import com.alibaba.fastjson.JSON;
import com.equipment.equipment.dao.EquipmentMapper;
import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.service.EquipemtService;
import com.equipment.equipment.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipemtService {

    @Autowired
    EquipmentMapper equipmentMapper;

    /**
     * 插入数据equipment表
     * @param equipment
     * @return
     */
    private  Integer insertData(Equipment equipment){
        return equipmentMapper.insertData(equipment);
    }


    @Override
    public void addData(Equipment equipment) throws InsertException {
        if (equipment.getEquipmentName() == null || equipment.getEquipmentName() == "") {

            throw new InsertException("插入数据失败。。名称不可为空！！");

        }else{
            Integer i = insertData(equipment);
            if (i != 1) {
                throw new InsertException("插入数据失败。。发生未知错误");
            }
        }
    }

    @Override
    public List<Equipment> listEquipment() {
        List<Equipment> list = equipmentMapper.selectAll();
        for(Equipment s :list){
            System.err.println(s.getEquipmentName()+"--------------------------->>");
        }
        return list;
    }

    @Override
    public Equipment equipmentData() {
        Equipment equipment = selectData();
        return equipment;
    }

    /**
     * 动态模糊查询
     * @param equipment
     * @return
     */
    public List<Equipment> getmh(Equipment equipment) {
        if(equipment.getEquipmentName() != null && equipment.getEquipmentName() !="")
            equipment.setEquipmentName("%"+equipment.getEquipmentName()+"%");
        if (equipment.getBrand() != null&&equipment.getBrand()!="")
            equipment.setBrand("%"+equipment.getBrand()+"%");
        if (equipment.getAfterSales() != null&&equipment.getAfterSales()!= "")
            equipment.setAfterSales("%"+equipment.getAfterSales()+"%");
        if (equipment.getDetectionDate()!= null&&equipment.getDetectionDate()!= "")
            equipment.setDetectionDate("%"+equipment.getDetectionDate()+"%");
        if (equipment.getModel()!= null&&equipment.getModel()!="")
            equipment.setModel("%"+equipment.getModel()+"%");
        if (equipment.getManufactureTime()!= null&&equipment.getManufactureTime()!="")
            equipment.setManufactureTime("%"+equipment.getManufactureTime()+"%");
        if (equipment.getShelfLife()!= null&&equipment.getShelfLife()!="")
            equipment.setShelfLife("%"+equipment.getShelfLife()+"%");
        if(equipment.getSupplierName()!=null&&equipment.getSupplierName()!="")
            equipment.setSupplierName("%"+equipment.getSupplierName()+"%");
        if(equipment.getDetectionTime()!= null&&equipment.getDetectionTime()!= "")
            equipment.setDetectionTime("%"+equipment.getDetectionTime()+"%");
        if (equipment.getQualified()!=null&&equipment.getQualified()!="")
            equipment.setQualified("%"+equipment.getQualified()+"%");

        List<Equipment> list = equipmentMapper.getA(equipment);
        return list;
    }












    /**
     * 查询表中最后一条数据
     */
    private Equipment selectData(){
        return equipmentMapper.selectData();
    }


    public  int upshujuA(Equipment equipment){
        int i = equipmentMapper.upshujuA(equipment);
        System.out.println(i+"---------------");
        return i;
    }

    @Override
    public List<Equipment> getDataByCode(Equipment equipment) {
        System.out.println("--------getCodeData-------"+ JSON.toJSONString(equipment));
        return equipmentMapper.getELDataByCode(equipment);
    }


}
