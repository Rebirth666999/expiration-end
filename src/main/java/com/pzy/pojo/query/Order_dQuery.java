package com.pzy.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order_dQuery {
    private Integer pageNum = 1;   // 当前的页码
    private Integer pageSize  = 5;   //每一页所显示的数量
    private String product_name;    // 根据产品名称查询
}
