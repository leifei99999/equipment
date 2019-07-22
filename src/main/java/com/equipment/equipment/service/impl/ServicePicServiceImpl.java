package com.equipment.equipment.service.impl;

import com.equipment.equipment.dao.ServicePicDao;
import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.entity.ServicePic;
import com.equipment.equipment.service.ServicePicService;
import com.equipment.equipment.service.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ServicePicServiceImpl implements ServicePicService {
    @Autowired
    ServicePicDao servicePicDao;


    /**
     * 拼接图片名字
     * @param armor
     * @return
     */
    private ServicePic Images (ServicePic armor){
        List<String> data = new ArrayList<String>();
        if (null != armor.getImg()){
            String[] str1 = armor.getImg().split("##");
            //下标0的值为null   从下标1开始赋值拼接
            for (int i=0;i<str1.length;i++){
//                  String s = "http://localhost:8080/image/"+str1[i+1];
                //String s = "http://120.26.40.124:8080/equipment/image/"+str1[i+1];
                String s =str1[i];
                data.add(s);
            }
        }
        armor.setData(data);
        return armor;
    }

    public ServicePic upimg(ServicePic servicePic) throws UpdateException {

        addPic(servicePic);
        Images(servicePic);
        servicePic.setImg(null);


        return servicePic;
    }
    /**
     * 上传维修记录图片信息
     */
        public int addPic(ServicePic servicePic) {
        Integer i = servicePicDao.addPic(servicePic);
        return i;
    }



}
