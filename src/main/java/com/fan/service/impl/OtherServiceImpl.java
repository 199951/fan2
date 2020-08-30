package com.fan.service.impl;

import com.fan.dao.OtherDao;
import com.fan.pojo.Other;
import com.fan.service.OtherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.List;
@Service
public class OtherServiceImpl implements OtherService {
    @Autowired
    private OtherDao otherDao;
    @Override
    public List<Other> findAll() {
        List<Other> all = otherDao.findAll();
        return all;
    }

    @Override
    public List<Other> findByTime(String beginTime) {
        return otherDao.findByTime(beginTime);
    }
}
