package com.fan.dao;

import com.fan.pojo.Other;

import javax.xml.crypto.Data;
import java.util.List;

public interface OtherDao {
    List<Other> findAll();
    List<Other> findByTime(String beginTime);
}
