package com.pzy.pojo.query;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressQuery {
    private Integer pageNum = 1;   // 当前的页码
    private Integer pageSize  = 5;   //每一页所显示的数量
    private String addressName;    // 根据地址查询
}
