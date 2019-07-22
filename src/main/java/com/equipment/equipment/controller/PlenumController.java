package com.equipment.equipment.controller;


import com.alibaba.fastjson.JSON;
import com.equipment.equipment.entity.EquipmentTime;
import com.equipment.equipment.entity.Produce;
import com.equipment.equipment.service.impl.ProduceServiceImpl;
import com.equipment.equipment.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/plenum")
public class PlenumController extends BaseController {
    @Autowired
    private ProduceServiceImpl usi;

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/getAllProduce")
    public ResponseResult<List<Produce>> getAll(){
        List<Produce> all = usi.getAll();
        return new ResponseResult<List<Produce>>(SUCCESS,all);
    }
    @RequestMapping("/getNewProduce")
    public ResponseResult<List<Produce>> getOne(){
        List<Produce> list = new ArrayList<Produce>();
        list.add(usi.getOne());
        return new ResponseResult<List<Produce>>(SUCCESS,list);
    }

    /**
     * 模糊查询
     * @param equipment
     * @return
     */
    @RequestMapping("/blurryGetPro")
    public ResponseResult<List<Produce>> blurryGet(@RequestBody Produce equipment){
        List<Produce> getmh = usi.getmh(equipment);
        return new ResponseResult<List<Produce>>(SUCCESS,getmh);
    }


    @RequestMapping("/upair")
    public ResponseResult<Void> updataEqui(@RequestBody Produce produce){
        int i = usi.upair(produce);
        if (i == 1){
            return new ResponseResult<Void>(SUCCESS,"修改数据成功！");
        }else{
            return new ResponseResult<Void>(FAIL,"修改数据失败！");
        }
    }


    @RequestMapping("/getProduceByCode")
    public ResponseResult<List<Produce>> getDataByCode(@RequestBody Produce produce){
        List<Produce> getmh = usi.getProduceByCode(produce);
        return new ResponseResult<List<Produce>>(SUCCESS,getmh);
    }
}
