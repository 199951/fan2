package com.fan.dao;

import com.fan.pojo.Login;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


public interface LoginDao {
    Login find(String bankCode);
    void update(Login login);
}
