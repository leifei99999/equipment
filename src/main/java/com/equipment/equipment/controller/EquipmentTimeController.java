package com.equipment.equipment.controller;

import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.entity.EquipmentTime;
import com.equipment.equipment.service.EquipemtTimeService;
import com.equipment.equipment.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/watergage")
public class EquipmentTimeController extends BaseController{

    @Autowired
    EquipemtTimeService equipemtTimeService;


    /**
     * 插入数据equipment_time表
     * @param equipmentTime 数据对象
     */
    @RequestMapping("/addDT")
    public ResponseResult<Void> addDate(@RequestBody EquipmentTime equipmentTime){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        equipmentTime.setId(uuid);
        equipemtTimeService.addDataTime(equipmentTime);
            return new ResponseResult<Void>(SUCCESS,"插入数据成功");
    }


    /**
     * 查询全部数据
     */
    @RequestMapping("/listEquiTime")
    public ResponseResult<List<EquipmentTime>> listEquipmentTime(){
        List<EquipmentTime> list = equipemtTimeService.listEquipmentTime();
        return new ResponseResult<List<EquipmentTime>>(SUCCESS,list);
    }

    /**
     * 查询表中最后一条数据
     */
    @RequestMapping("/equiTimeData")
    public ResponseResult<List<EquipmentTime>> equipmenTimetData(){
        EquipmentTime equipmentTime = equipemtTimeService.equipmenTimetData();
        List<EquipmentTime> list  = new ArrayList<EquipmentTime>();
        list.add(equipmentTime);
        return new ResponseResult<List<EquipmentTime>>(SUCCESS,list);
    }



    /**
     * 模糊查询
     * @param equipment
     * @return
     */
    @RequestMapping("/blurryGetTime")
    public ResponseResult<List<EquipmentTime>> blurryGet(@RequestBody EquipmentTime equipment){
        List<EquipmentTime> getmh = equipemtTimeService.getmh(equipment);
        return new ResponseResult<List<EquipmentTime>>(SUCCESS,getmh);
    }


    @RequestMapping("/updataEquiT")
    public ResponseResult<Void> updataEqui(@RequestBody EquipmentTime equipment){
        int i = equipemtTimeService.upshujuA(equipment);
        System.out.println(equipment.getId()+equipment.getDetectionTime()+equipment.getDetectionDate());
        if (i == 1){
            return new ResponseResult<Void>(SUCCESS,"修改数据成功！");
        }else{
            return new ResponseResult<Void>(FAIL,"修改数据失败！");
        }
    }


    @RequestMapping("/getGageByCode")
    public ResponseResult<List<EquipmentTime>> getDataByCode(@RequestBody EquipmentTime equipment){
        List<EquipmentTime> getmh = equipemtTimeService.getDataByCode(equipment);
        return new ResponseResult<List<EquipmentTime>>(SUCCESS,getmh);
    }

}
