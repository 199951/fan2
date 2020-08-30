package com.fan.controller;

import com.fan.common.JsonResult;
import com.fan.pojo.Login;
import com.fan.uitls.StrUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @RequestMapping("/user")
    @ResponseBody
    public JsonResult loginInfo(HttpSession session){
        Login login = (Login)session.getAttribute(StrUtils.LOGIN_USER);
        JsonResult jsonResult = null;
        if (login!= null) {
            jsonResult = new JsonResult(1,login);
        } else  {
            jsonResult = new JsonResult(0, "用户未登录");
        }
        return jsonResult;
    }
}
