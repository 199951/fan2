package com.fan.controller;

import com.fan.common.JsonResult;
import com.fan.pojo.Login;
import com.fan.service.LoginService;
import com.fan.uitls.JsonUtil;
import com.fan.uitls.StrUtils;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Size;
import java.util.Iterator;

@Controller
@Validated
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/login")
    @ResponseBody
    public JsonResult login(@NotEmpty(message = "账号不能为空") String bankCode, @Size(min = 1,max = 6,message = "太长了") String password, HttpSession session) {
        Login login = loginService.find(bankCode, password);
        session.setAttribute(StrUtils.LOGIN_USER, login);
        JsonResult jsonResult = new JsonResult(1, null);
        return jsonResult;
    }
   /* //现在报了一个异常ConstraintViolationException
    //处理这个异常,捕捉ConstraintViolationException
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public JsonResult constraintViolationException(ConstraintViolationException ex) {
        //y验证不通过的信息
        Iterator<ConstraintViolation<?>> iterator = ex.getConstraintViolations().iterator();
        String message = null;
        if (iterator.hasNext()) {
            message = iterator.next().getMessage();
            System.out.println(message);

        }
        return new JsonResult(0,message);
    }*/

}

