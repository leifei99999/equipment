package com.equipment.equipment.controller;

import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.service.ArmorService;
import com.equipment.equipment.util.ResponseResult;
import com.equipment.equipment.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/suit")
public class ArmorController extends BaseController{

    @Autowired
    ArmorService usersService;

    TimeUtil tu = new TimeUtil();


    /**
     * 插入数据armor表
     * @param users 数据对象
     */
    @RequestMapping(value = "/addArmor")
    public ResponseResult<Void> addDate(@RequestBody Armor users ){
        System.out.println(users.getWarehouseId()+users.getRinseService());
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String time = tu.gettime();//获取当前时间
        users.setId(uuid);
        users.setNowtime(time);
        usersService.addUsers(users);
        return new ResponseResult<Void>(SUCCESS,"插入数据成功！");
    }

    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping("/listArmor")
    public  ResponseResult<List<Armor>> listUsers(@RequestBody Armor armor){
            List<Armor> list = usersService.listUsers(armor);
        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }

    /**
     * 查询表中最后一条数据
     */
    @RequestMapping("/ArmorData")
    public ResponseResult<List<Armor>> usersData(@RequestBody Armor armor){

        Armor users = usersService.usersData(armor);
        List<Armor> list = new ArrayList<Armor>();
        list.add(users);

        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }

    /**
     * 修改状态信息
     */
    @RequestMapping("/updateState")
    public ResponseResult<Void> usersState(@RequestBody Armor armor){
        usersService.usersState(armor.getId(),armor.getState());
        return new ResponseResult<>(SUCCESS,"更新成功！");
    }


    /**
     * 模糊查询
     * @param armor
     * @return
     */
    @RequestMapping("/blurryGetAr")
    public ResponseResult<List<Armor>> blurryGet(@RequestBody Armor armor){
        List<Armor> getmh = usersService.getm(armor);
        //System.out.println(getmh.get(0).getAffiliationcOmpany()+"9999999999");
        return new ResponseResult<List<Armor>>(SUCCESS,getmh);
    }

    /**
     * 通过状态查询所有已清洗或未清洗
     * @param armor
     * @return
     */
    @RequestMapping("/getState")
    public ResponseResult<List<Armor>> getState(@RequestBody Armor armor){
        List<Armor> f = usersService.getF(armor);
        return new ResponseResult<List<Armor>>(SUCCESS,f);
    }


    /**
     * 查询全部数据
     * @return
     */
    @RequestMapping("/getToId")
    public  ResponseResult<List<Armor>> getToId(@RequestBody Armor armor){

        List<Armor> list = usersService.selecid(armor);

        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }

    /**
     * 通过二维码获取信息
     * @param armor
     * @return
     */
    @RequestMapping("/getSuitDataByCode")
    public  ResponseResult<List<Armor>> getDataByCode(@RequestBody Armor armor){

        List<Armor> list = usersService.getDataByCode(armor);

        return new ResponseResult<List<Armor>>(SUCCESS,list);
    }
}