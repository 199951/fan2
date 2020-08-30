package com.fan.uitls;

import com.fan.common.JsonResult;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class JsonUtil {
    public static void writeJsonInfo(int code, Object info, HttpServletResponse response){
        JsonResult jsonResult = new JsonResult(code, info);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String s = objectMapper.writeValueAsString(jsonResult);
            PrintWriter writer = response.getWriter();
            writer.write(s);//打印
            writer.flush();//刷新
            writer.close();//关闭
        } catch (JsonProcessingException e) {

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
