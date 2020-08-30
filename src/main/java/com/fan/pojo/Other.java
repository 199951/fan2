package com.fan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Other {
    private Date createTime;
    private String income;
    private String pay;
    private String balance;
    private String consumType;
    private String comment;
}
