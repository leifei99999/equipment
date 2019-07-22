package com.equipment.equipment.service.impl;

import com.equipment.equipment.dao.ArmorMapper;
import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.entity.ServicePic;
import com.equipment.equipment.service.ArmorService;
import com.equipment.equipment.service.ServicePicService;
import com.equipment.equipment.service.exception.InsertException;
import com.equipment.equipment.service.exception.UpdateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArmorServiceImpl implements ArmorService {

    @Autowired
    ArmorMapper usersMapper;

    @Autowired
    private ServicePicService sps;


    /**
     * 插入数据users表
     *
     * @param users
     * @return
     */
    private Integer insertUsers(Armor users) {
        return usersMapper.insertData(users);
    }

    @Override
    public void addUsers(Armor users) throws InsertException {
        if (users.getServicePic() != null) {
            List<String> data = users.getServicePic().getData();
            Integer integer = addImge(data);
            users.setRecordImage(integer);
            insertUsers(users);
        } else {
            insertUsers(users);
        }


    }

    @Override
    public List<Armor> listUsers(Armor armor) {
        List<Armor> armors;
        if (armor.getRinseService() == 1) {
            armors = selectAll(armor);
            for (Armor ar : armors) {
                //拼接RecordImage url
                Images(ar);
                //将recordImage值清空
                ar.setRecordImage(null);
            }
        } else {
            armors = usersMapper.select(armor);
        }

        return armors;
    }

    @Override
    public Armor usersData(Armor armor) {
        Armor users;
        if (armor.getRinseService() == 1) {
            users = selectData(armor);
            //拼接RecordImage url
            Images(users);
            //将recordImage值清空
            users.setRecordImage(null);
        }else {
            users = usersMapper.selectDa(armor);
        }

        return users;
    }

    @Override
    public void usersState(String id, int state) {
        int i = updateState(id, state);
        if (i != 1) {
            throw new UpdateException("更新状态失败！ 请重试");
        }
    }

   /* public Armor upRecordImages(Armor armor) throws UpdateException {

        int i=addRecordImages(armor);

        Images(armor);
        armor.setRecordImage(null);
        if (i != 1){
            throw new UpdateException("上传信息失败！ 请重试");
        }
        return armor;
    }*/

    @Override
    public void upInsert(Armor armor) {
        int i = addInsert(armor);
        if (i != 1) {
            throw new UpdateException("修改信息失败！ 请重试");
        }
    }

    /**
     * 上传维修记录图片信息
     */
    /*private Integer addRecordImages(Armor armor) {
        return usersMapper.insertUsers(armor);
    }*/

    /**
     * 查询全部数据
     */
    private List<Armor> selectAll(Armor armor) {
        List<Armor> armors = usersMapper.selectAll(armor);
        return armors;
    }

    /**
     * 查询表中最后一条数据
     */
    private Armor selectData(Armor armor) {
        return usersMapper.selectData(armor);
    }

    /**
     * 修改状态信息
     */
    private Integer updateState(String id, int state) {
        return usersMapper.updateState(id, state);
    }

    /**
     * 修改维修信息
     */
    private Integer addInsert(Armor armor) {
        return usersMapper.addInsert(armor);
    }

    /**
     * 拼接图片路径
     */
    private Armor Images(Armor armor) {
        List<String> data = new ArrayList<String>();
        if (null != armor.getRecordImage()) {
            String[] str1 = armor.getServicePic().getImg().split("##");
            //下标0的值为null   从下标1开始赋值拼接
            for (int i = 0; i < str1.length; i++) {
//                  String s = "http://localhost:8080/image/"+str1[i+1];
                String s = str1[i];
                data.add(s);

            }
        }
        System.out.println(armor.getId());
        armor.getServicePic().setData(data);
        return armor;
    }

    private Integer addImge(List<String> data) {
        ServicePic servicePic1 = new ServicePic();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            String url = data.get(i);
            String url1 = null;
            if (data.size() > i + 1)
                url1 = data.get(i + 1);
            if (url1 != null) {
                stringBuilder.append(url + "##");
            } else {
                stringBuilder.append(url);
            }
        }
        servicePic1.setImg(String.valueOf(stringBuilder));
        ServicePic upimg = sps.upimg(servicePic1);

        return upimg.getReid();
    }


    public List<Armor> getm(Armor equipment) {
        if(equipment.getUsername() != null && equipment.getUsername() !="")
            equipment.setUsername("%"+equipment.getUsername()+"%");
        if (equipment.getBrand() != null&&equipment.getBrand()!="")
            equipment.setBrand("%"+equipment.getBrand()+"%");
        if (equipment.getAffiliationcOmpany() != null&&equipment.getAffiliationcOmpany()!= "")
            equipment.setAffiliationcOmpany("%"+equipment.getAffiliationcOmpany()+"%");
        if (equipment.getBloodType()!= null&&equipment.getBloodType()!= "")
            equipment.setBloodType("%"+equipment.getBloodType()+"%");
        if (equipment.getModel()!= null&&equipment.getModel()!="")
            equipment.setModel("%"+equipment.getModel()+"%");
        if (equipment.getManufactureTime()!= null&&equipment.getManufactureTime()!="")
            equipment.setManufactureTime("%"+equipment.getManufactureTime()+"%");

        System.out.println(equipment.getUsername()+"6666");
        List<Armor> list = null;
        if(equipment.getRinseService() == 1){

            list = usersMapper.getD(equipment);
        }else{
            list = usersMapper.getE(equipment);
          //  System.out.println("我是"+list.get(0).getAffiliationcOmpany()+"---------");
        }

        return list;
    }


    public List<Armor> getF(Armor armor){
        List<Armor> f = usersMapper.getF(armor);

        return f;
    }



    public List<Armor> selecid(Armor armor){
        List<Armor> selecid = usersMapper.selecid(armor);
        return selecid;
    }

    @Override
    public List<Armor> getDataByCode(Armor armor) {
        return usersMapper.getDataByCode(armor);
    }


}
