package com.fan.service;

import com.fan.pojo.Other;

import javax.xml.crypto.Data;
import java.util.List;

public interface OtherService {
    List<Other> findAll();
    List<Other> findByTime(String beginTime);
}
