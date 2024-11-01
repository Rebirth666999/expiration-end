package com.pzy.dao;

import com.pzy.entity.Order_m;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface Order_mDao {
    public List<Order_m> listOrder_mByNo(String no);

    public int deleteOrder_mById(Integer id);

    public int updateOrder_m(Order_m order_m);

    public int addOrder_m(Order_m order_m);
}
