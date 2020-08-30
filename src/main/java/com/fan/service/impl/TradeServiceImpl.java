package com.fan.service.impl;

import com.fan.dao.LoginDao;
import com.fan.dao.TradeDao;
import com.fan.pojo.Login;
import com.fan.pojo.Trade;
import com.fan.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TradeServiceImpl implements TradeService {
    @Autowired
    private LoginDao loginDao;
    @Autowired
    private TradeDao tradeDao;
    @Override
    public void transfer(String bankCode, String otherCode, Double money) {
       //要转账的用户
        Login login = loginDao.find(bankCode);
        //收款用户
        Login login1 = loginDao.find(otherCode);
        if(otherCode == null){
            throw new RuntimeException("用户不存在");
        }
        if(login.getBalance() < money){
            throw new RuntimeException("余额不足");
        }
        if(login.getBankCode().equals(otherCode)){
            throw new RuntimeException("不能给自己转账");
        }
        //转账用户
        Trade trade = new Trade();
        trade.setUid(login.getUid());//转账账户的uid赋值为转账用户的uid
        trade.setBalance(login.getBalance()-money);//转账用户的余额
        trade.setMoney(0-money);//转账多少
        tradeDao.add(trade);//添加一条转账信息
        login.setBalance(login.getBalance()-money);
        loginDao.update(login);
        //收款的用户
        Trade trade1 = new Trade();
        trade1.setUid(login1.getUid());
        trade1.setBalance(login1.getBalance()+money);;
        trade1.setMoney(money);
        tradeDao.add(trade1);//收款用户添加一条信息
        login1.setBalance(login1.getBalance()+money);
        loginDao.update(login1);//修改一下收款用户的信息
    }
}
