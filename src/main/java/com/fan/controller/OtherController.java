package com.fan.controller;

import com.fan.common.JsonResult;
import com.fan.pojo.Other;
import com.fan.service.OtherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.xml.crypto.Data;
import java.util.List;

@Controller
@RequestMapping("/other")
public class OtherController {
    @Autowired
    private OtherService otherService;
    @RequestMapping("/findAll")
    @ResponseBody
    public JsonResult findAll(){
        List<Other> all = otherService.findAll();
        JsonResult jsonResult = new JsonResult(1,all);
        return jsonResult;
    }
    @RequestMapping("/findByTime")
    public JsonResult findByTime(HttpServletRequest request){
        String beginTime = request.getParameter("beginTime");
        List<Other> byTime = otherService.findByTime(beginTime);
        JsonResult jsonResult = new JsonResult(1,byTime);
        return jsonResult;
    }
}
