package com.equipment.equipment.controller;


import com.alibaba.fastjson.JSON;
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
public class ProduceController extends BaseController {
    @Autowired
    private ProduceServiceImpl usi;
   // @Autowired
   // RestTemplate restTemplate;
    @PostMapping(value = "/write",produces = {"application/json; charset=GBK"})
    public String write(@RequestBody String s){
        System.out.println(s);
        if(s.length()<20){
            return "No data since last time";
        }else{


       String substring = s.substring(0, s.length()-1);
       // restTemplate.postForEntity()
       System.out.println(s);

        String decode=null;
        //将传进来的参数转为字符串
        try {
           decode = URLDecoder.decode(substring, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
       // System.out.println(decode+"+++++++++++++++++++++++++++++++++++++++++++>>");
        //String utfString = utf.hexStringToString(s);
        //System.out.println(s);//测试
        //将字符串转为json字符串
        //String str = JSON.toJSONString(s);
        //System.out.println(str);//测试
        //将json字符串转成list集合
        List<Produce> list = JSON.parseArray(decode, Produce.class);
        for (int i=0;i<list.size();i++){

            list.get(i).setAir("30");
        }
        //System.out.println(list.get(0).getOperator());
        String res = usi.addAll(list);
        return res;
      }
    }

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
    @RequestMapping("blurryGetPro")
    public ResponseResult<List<Produce>> blurryGet(@RequestBody Produce equipment){
        List<Produce> getmh = usi.getmh(equipment);
        return new ResponseResult<List<Produce>>(SUCCESS,getmh);
    }


    @RequestMapping("upair")
    public ResponseResult<Void> updataEqui(@RequestBody Produce produce){
        int i = usi.upair(produce);
        if (i == 1){
            return new ResponseResult<Void>(SUCCESS,"修改数据成功！");
        }else{
            return new ResponseResult<Void>(FAIL,"修改数据失败！");
        }
    }
}
