package com.fan.controller;

import com.fan.common.JsonResult;
import com.fan.pojo.Login;
import com.fan.service.LoginService;
import com.fan.uitls.StrUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/fan")
public class UploadController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/uploadFile")
    @ResponseBody
    private JsonResult uploadFile(@RequestParam MultipartFile upfile, HttpSession session) {
        Login login = (Login) session.getAttribute(StrUtils.LOGIN_USER);
        //要把上传的文件存起来
        //1.要把图片的路径的存起来  存到数据库中
        //2.将上传的图片放到咱们配置好的虚拟环境下面
        if (login == null) {
            return new JsonResult(0, "未登录");
        }
        //1.上传文件的目录
        String dir = "E:\\upload";
        //2.获取上传文件的名字
        String fileName = upfile.getOriginalFilename();
        //3.判断目录是否存在
        File dirFile = new File(dir);
            if (!dirFile.exists()) {
                dirFile.mkdirs();
            }
        //4.要保存文件的file对象
        File newFile = new File(dir, fileName);
        try {
            //保存
            upfile.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //并且写入数据库，要把图片的路径的存起来  存到数据库中
        loginService.updateHeadImg(login.getUid(), "/upload/" + fileName);
        login.setImgPath("/upload/" + fileName);
        session.setAttribute(StrUtils.LOGIN_USER,login);
        return new JsonResult(1, "上传成功");
    }
}
