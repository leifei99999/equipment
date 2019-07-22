package com.equipment.equipment.controller;


import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.entity.Produce;
import com.equipment.equipment.entity.WmsCode;
import com.equipment.equipment.service.EquipemtService;
import com.equipment.equipment.service.WmsCodeService;
import com.equipment.equipment.util.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/wmscode")
public class WmsCodeController extends BaseController{

    @Autowired
    WmsCodeService wmsCodeService;



    @RequestMapping("/getData")
    public ResponseResult<List<WmsCode>> getData(@RequestBody WmsCode wmsCode){
        List<WmsCode> list = new ArrayList<WmsCode>();
        list.add(wmsCodeService.getCodeData(wmsCode));
        return new ResponseResult<List<WmsCode>>(SUCCESS,list);
    }





}
