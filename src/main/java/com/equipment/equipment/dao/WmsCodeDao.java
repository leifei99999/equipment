package com.equipment.equipment.dao;

import com.equipment.equipment.entity.Armor;
import com.equipment.equipment.entity.WmsCode;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface WmsCodeDao {


    WmsCode getData(WmsCode wmsCode);
}
