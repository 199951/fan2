package com.fan.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {
    private Integer uid;
    private String bankCode;
    private String password;
    private Double balance;
    private Integer status;
    private String imgPath;
}
