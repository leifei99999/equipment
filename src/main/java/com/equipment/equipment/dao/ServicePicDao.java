package com.equipment.equipment.dao;


import com.equipment.equipment.entity.ServicePic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface ServicePicDao {
    /**
     *
     * 增加图片
     * @return 图片对应防护服信息id
     */
    int addPic(ServicePic servicePic);
}
