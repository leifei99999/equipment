package com.equipment.equipment.service.impl;

import com.equipment.equipment.dao.EquipmentTimeMapper;
import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.entity.EquipmentTime;
import com.equipment.equipment.service.EquipemtTimeService;
import com.equipment.equipment.service.exception.InsertException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentTimeServiceImpl implements EquipemtTimeService {

    @Autowired
    EquipmentTimeMapper equipmentTimeMapper;


    /**
     * 插入数据equipment_time表
     * @param equipmentTime
     * @return
     */
    private Integer insertDataTime(EquipmentTime equipmentTime){
        return equipmentTimeMapper.insertDataTime(equipmentTime);
    }

    @Override
    public void addDataTime(EquipmentTime equipmentTime) throws InsertException {
        if (equipmentTime.getEquipmentName() == null || equipmentTime.getEquipmentName() == ""){
            System.err.println(equipmentTime.getEquipmentName()+"----->>");
            throw new InsertException("插入数据失败。。名称不可为空！！");
        }else{
            System.err.println(equipmentTime.getEquipmentName()+"----->>");
            Integer i = insertDataTime(equipmentTime);
            if (i != 1) {
                throw new InsertException("插入数据失败。。发生未知错误");
            }
        }
    }

    @Override
    public List<EquipmentTime> listEquipmentTime() {
        List<EquipmentTime> list = selectAll();
        return list;
    }

    @Override
    public EquipmentTime equipmenTimetData() {
        EquipmentTime equipmentTime = selectData();
        return equipmentTime;
    }

    /**
     * 查询全部数据
     */
    private List<EquipmentTime> selectAll(){
        return equipmentTimeMapper.selectAll();
    }

    /**
     * 查询表中最后一条数据
     */
    private EquipmentTime selectData(){
        return equipmentTimeMapper.selectData();
    }

    public List<EquipmentTime> getmh(EquipmentTime equipment) {
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
        if (equipment.getNextTestTime()!= null&&equipment.getNextTestTime()!="")
            equipment.setNextTestTime("%"+equipment.getNextTestTime()+"%");

        List<EquipmentTime> list = equipmentTimeMapper.getB(equipment);
        return list;
    }

    public  int upshujuA(EquipmentTime equipment){
        int i = equipmentTimeMapper.upshujuA(equipment);
        System.out.println(i+"---------------");
        return i;
    }

    @Override
    public List<EquipmentTime> getDataByCode(EquipmentTime equipment) {
        return equipmentTimeMapper.getGageDataByCode(equipment);
    }


}
