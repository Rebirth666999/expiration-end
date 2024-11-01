package com.pzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer user_id;//用户id
    private String name;//用户姓名
    private String passwd;//密码
    private String account;//账号
    private String phone;//电话号码
    private String email;//邮箱地址
}