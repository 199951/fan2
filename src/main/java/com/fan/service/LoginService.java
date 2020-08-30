package com.fan.service;

import com.fan.pojo.Login;

public interface LoginService {
    Login find(String bankCode, String password);
    void updateHeadImg(Integer uid, String imgPath);
}
