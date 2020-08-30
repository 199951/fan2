package com.fan.service.impl;

import com.fan.dao.LoginDao;
import com.fan.pojo.Login;
import com.fan.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public Login find(String bankCode, String password) {
        Login login = loginDao.find(bankCode);
        if(login.getBankCode() == null){
            throw new RuntimeException("没有账号");
        }
        if(!login.getPassword().equals(password)){
            throw new RuntimeException("密码错了");
        }
        return login;
    }

    @Override
    public void updateHeadImg(Integer uid, String imgPath) {
        Login login = new Login();
        login.setUid(uid);
        login.setImgPath(imgPath);
        loginDao.update(login);
    }
}
