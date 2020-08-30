package com.fan.convert;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
* 实现Converter的接口这个接口是个泛型接口
* 第一个参数：要被转换的字符串
* 第二个参数：要转成什么样子
* */
public class CustomerDateConvert implements Converter<String, Date> {
    //
    private SimpleDateFormat[] sdfs =new SimpleDateFormat[]{
            new SimpleDateFormat("yyyy-MM-dd"),
            new SimpleDateFormat("yyyyMMdd"),
            new SimpleDateFormat("yyyy年MM月dd日")
    };
    @Override
    public Date convert(String s) {
        if (s == null|| s.isEmpty())  {
            return null;
        }
        for (SimpleDateFormat sdf:sdfs) {
            //把字符串变成一个Date    2008年5月12号
            try {
                return sdf.parse(s);
            } catch (ParseException e) {
                //e.printStackTrace();
                continue;
            }
        }
        return null;
    }
}
