package com.pzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Integer addr_id;//地址id
    private Integer user_id;//用户id
    private String addressName;//具体地址
    private String contact;//联系方式
    private String remark;//备注
}
