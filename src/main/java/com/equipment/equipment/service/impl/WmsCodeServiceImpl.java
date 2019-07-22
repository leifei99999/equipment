package com.equipment.equipment.service.impl;

import com.alibaba.fastjson.JSON;
import com.equipment.equipment.dao.WmsCodeDao;
import com.equipment.equipment.entity.WmsCode;
import com.equipment.equipment.service.WmsCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
    public class WmsCodeServiceImpl implements WmsCodeService {

        @Autowired
        WmsCodeDao wmsCodeDao;

        @Autowired
        private WmsCodeService wmsCodeService;

        @Override
        public WmsCode getCodeData(WmsCode wmsCode) {
            WmsCode data = wmsCodeDao.getData(wmsCode);
            System.out.println("--------getCodeData-------"+ JSON.toJSONString(data));
            return data;
        }
    }
