package com.equipment.equipment.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.equipment.equipment.entity.Equipment;
import com.equipment.equipment.service.EquipemtService;
import com.equipment.equipment.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/respirator")
public class EquipmentController extends BaseController{

    @Autowired
    EquipemtService equipemtService;


    /**
     * 插入数据equipment表
     * @param equipment 数据对象
     */
    @RequestMapping("/add")
    public ResponseResult<Void> addDate(@RequestBody Equipment equipment){
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        equipment.setId(uuid);
        System.out.println(equipment.getEquipmentName());
            equipemtService.addData(equipment);
            return new ResponseResult<Void>(SUCCESS,"插入数据成功");
    }

    /**
     * 查询全部数据
     */
    @RequestMapping("/listEqui")
    public ResponseResult<List<Equipment>> listEquipment(){
        List list = equipemtService.listEquipment();
        return new ResponseResult<List<Equipment>>(SUCCESS,list);
    }

    /**
     * 查询最后一条数据
     */
    @RequestMapping("/equiData")
    public ResponseResult<List<Equipment>> equipmentData(){
        Equipment equipment = equipemtService.equipmentData();
        List<Equipment> list  = new ArrayList<Equipment>();
        list.add(equipment);
        return new ResponseResult<List<Equipment>>(SUCCESS,list);
    }

    /**
     * 模糊查询
     * @param equipment
     * @return
     */
    @RequestMapping("/blurryGet")
    public ResponseResult<List<Equipment>> blurryGet(@RequestBody Equipment equipment){
        List<Equipment> getmh = equipemtService.getmh(equipment);
        return new ResponseResult<List<Equipment>>(SUCCESS,getmh);
    }


    @RequestMapping("/updataEqui")
    public ResponseResult<Void> updataEqui(@RequestBody Equipment equipment){
        int i = equipemtService.upshujuA(equipment);
        System.out.println(equipment.getId()+equipment.getDetectionTime()+equipment.getDetectionDate());
        if (i == 1){
            return new ResponseResult<Void>(SUCCESS,"修改数据成功！");
        }else{
            return new ResponseResult<Void>(FAIL,"修改数据失败！");
        }
    }


    @RequestMapping("/getEquipmentByCode")
    public ResponseResult<List<Equipment>> getDataByCode(@RequestBody Equipment equipment){
        List<Equipment> getmh = equipemtService.getDataByCode(equipment);

        ResponseResult t=new ResponseResult<List<Equipment>>(SUCCESS,getmh);
        System.out.println("--------getEquipmentByCode-------"+ JSON.toJSONString(t));
        return new ResponseResult<List<Equipment>>(SUCCESS,getmh);
    }

}
