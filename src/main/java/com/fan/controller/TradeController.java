package com.fan.controller;

import com.fan.common.JsonResult;
import com.fan.pojo.Login;
import com.fan.service.TradeService;
import com.fan.uitls.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/fan")
public class TradeController {
    @Autowired
    private TradeService tradeService;
    @RequestMapping("/transfer")
    @ResponseBody
    public JsonResult transfer(String otherCode, Double money, HttpSession session) {
        Login login = (Login)session.getAttribute(StrUtils.LOGIN_USER);
        tradeService.transfer(login.getBankCode(),otherCode, money);
        return new JsonResult(1, "转账成功");
    }
}
