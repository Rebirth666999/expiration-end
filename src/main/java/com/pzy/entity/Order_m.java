package com.pzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_m {
    private Integer order_id;//订单id
    private Integer user_id;//用户id
    private String order_no;//订单编号
    private String order_date;//下单日期
    private String date;//审核日期
    private String audit;//审核人
    private Integer addr_id;//地址id
    private String remark;//备注
}
