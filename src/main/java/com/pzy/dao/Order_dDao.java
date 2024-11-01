package com.pzy.dao;

import com.pzy.entity.Order_d;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Order_dDao {
    public List<Order_d> listOrder_dByName(String name);

    public int deleteOrder_dById(Integer id);

    public int updateOrder_d(Order_d order_d);

    public int addOrder_d(Order_d order_d);
}