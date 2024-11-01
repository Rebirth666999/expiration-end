package com.pzy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_d {
    private Integer dd_id;//从单id
    private Integer order_id;//订单id
    private String product_id;//产品id
    private String product_name;//产品名称
    private String product_speci;//产品规格
    private Integer product_num;//产品数量
    private String product_unit;//单位
    private float unit_price;//单价
    private float total_price;//总价
}
