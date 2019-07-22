package com.equipment.equipment.service.impl;

import com.equipment.equipment.dao.ProduceDao;
import com.equipment.equipment.entity.EquipmentTime;
import com.equipment.equipment.entity.Produce;
import com.equipment.equipment.service.ProduceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProduceServiceImpl implements ProduceService {
    @Autowired
    ProduceDao ud;

    /**
     * 写入数据库，
     * @param
     * @return
     */

    @Override
    public String addAll(List<Produce> list) {
        int sucnum = 0;//成功条数
        int defnum = 0;//失败条数
        System.out.println(list);
        for (int i =0; i<list.size();i++) {
            Produce pd = new Produce();
            String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
            pd.setId(uuid);
            pd.setData(list.get(i).getData());
            pd.setTime(list.get(i).getTime());
            pd.setInflatingWater(list.get(i).getInflatingWater());
            pd.setReducedWater(list.get(i).getReducedWater());
            pd.setDeformation(list.get(i).getDeformation());
            pd.setState(list.get(i).getState());
            pd.setDetectionNo(list.get(i).getDetectionNo());
            pd.setOutNo(list.get(i).getOutNo());
            pd.setProductNo(list.get(i).getProductNo());
            pd.setExperimenter(list.get(i).getExperimenter());
            pd.setOperator(list.get(i).getOperator());
            pd.setAir(list.get(i).getAir());
            int res = ud.addOne(pd);
            if(res==1){
                sucnum++;
            }else {
                defnum++;
            }

        }
        String print = "\t"+sucnum+"\t"+defnum;
        return print;
    }

    /**
     * 查询全部
     * @return
     */
    public List<Produce> getAll() {
        List<Produce> all = ud.getAll();
        return all;
    }

    @Override
    public Produce getOne() {
        Produce last = ud.getLast();
        return last;
    }

    public List<Produce> getmh(Produce equipment) {

        if(equipment.getData() != null && equipment.getData() !="")
            equipment.setData("%"+equipment.getData()+"%");
        if (equipment.getTime() != null&&equipment.getTime()!="")
            equipment.setTime("%"+equipment.getTime()+"%");
        if (equipment.getInflatingWater() != null &&equipment.getInflatingWater()!= "")
            equipment.setInflatingWater("%"+equipment.getInflatingWater()+"%");
        if (equipment.getReducedWater()!= null&&equipment.getReducedWater()!= "")
            equipment.setReducedWater("%"+equipment.getReducedWater()+"%");
        if (equipment.getDeformation()!= null&&equipment.getDeformation()!="")
            equipment.setDeformation("%"+equipment.getDeformation()+"%");
        if (equipment.getState()!= null&&equipment.getState()!="")
            equipment.setState("%"+equipment.getState()+"%");
        if (equipment.getDetectionNo()!= null&&equipment.getDetectionNo()!="")
            equipment.setDetectionNo("%"+equipment.getDetectionNo()+"%");
        if(equipment.getOutNo()!=null&&equipment.getOutNo()!="")
            equipment.setOutNo("%"+equipment.getOutNo()+"%");
        if(equipment.getProductNo()!= null&&equipment.getProductNo()!= "")
            equipment.setProductNo("%"+equipment.getProductNo()+"%");
        if (equipment.getExperimenter()!=null&&equipment.getExperimenter()!="")
            equipment.setExperimenter("%"+equipment.getExperimenter()+"%");
        if (equipment.getOperator()!= null&&equipment.getOperator()!="")
            equipment.setOperator("%"+equipment.getOperator()+"%");

        List<Produce> list = ud.getC(equipment);
        return list;
    }

    @Override
    public List<Produce> getProduceByCode(Produce produce) {

        return ud.getProduceByCode(produce);
    }


    /**
     * 修改气压
     * @param produce
     * @return
     */
    public int upair(Produce produce){
        int upair = ud.upair(produce);
        return upair;
    }

}
