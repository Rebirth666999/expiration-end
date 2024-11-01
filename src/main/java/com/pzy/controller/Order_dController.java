package com.pzy.controller;

import com.alibaba.fastjson.JSON;
import com.pzy.dao.Order_dDao;
import com.pzy.entity.Order_d;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Order_dController {
    @Autowired
    private Order_dDao order_dDao;

    @GetMapping("/listOrder_d")
    @ResponseBody
    @CrossOrigin
    public List<Order_d> listOrder_d() {
        List<Order_d> listOrder_d = order_dDao.listOrder_dByName("");
        //System.out.println(JSON.toJSONString(listOrder_d));
        return listOrder_d;
    }

    @PostMapping("/selectOrder_d/{name}")
    @ResponseBody
    @CrossOrigin
    public List<Order_d> selectOrder_d(@PathVariable String name) {
        List<Order_d> listOrder_d = order_dDao.listOrder_dByName(name);
        //System.out.println(JSON.toJSONString(listOrder_d));
        return listOrder_d;
    }

    @GetMapping("/deleteOrder_d/{id}")
    @ResponseBody
    @CrossOrigin
    public boolean deleteOrder_d(@PathVariable Integer id) {
        order_dDao.deleteOrder_dById(id);
        return true;
    }

    @PostMapping("/addOrder_d")
    @ResponseBody
    @CrossOrigin
    public boolean addOrder_d(@RequestBody Order_d order_d) {
        Integer order_id = order_d.getOrder_id();
        String product_id = order_d.getProduct_id();
        String product_name = order_d.getProduct_name();
        String product_speci= order_d.getProduct_speci();
        Integer product_num = order_d.getProduct_num();
        String product_unit= order_d.getProduct_unit();
        Float unit_price= order_d.getUnit_price();
        Float total_price= product_num*unit_price;

        order_d.setOrder_id(order_id);
        order_d.setProduct_id(product_id);
        order_d.setProduct_name(product_name);
        order_d.setProduct_speci(product_speci);
        order_d.setProduct_num(product_num);
        order_d.setProduct_unit(product_unit);
        order_d.setUnit_price(unit_price);
        order_d.setTotal_price(total_price);

        order_dDao.addOrder_d(order_d);

        return true;
    }

    @PostMapping("/updateOrder_d")
    @ResponseBody
    @CrossOrigin
    public boolean updateOrder_d(@RequestBody Order_d order_d) {
        Integer id = order_d.getOrder_id();
        Integer order_id = order_d.getOrder_id();
        String product_id = order_d.getProduct_id();
        String product_name = order_d.getProduct_name();
        String product_speci= order_d.getProduct_speci();
        Integer product_num = order_d.getProduct_num();
        String product_unit= order_d.getProduct_unit();
        Float unit_price= order_d.getUnit_price();
        Float total_price= product_num*unit_price;

        order_d.setOrder_id(id);
        order_d.setOrder_id(order_id);
        order_d.setProduct_id(product_id);
        order_d.setProduct_name(product_name);
        order_d.setProduct_speci(product_speci);
        order_d.setProduct_num(product_num);
        order_d.setProduct_unit(product_unit);
        order_d.setUnit_price(unit_price);
        order_d.setTotal_price(total_price);

        order_dDao.updateOrder_d(order_d);

        return true;
    }
}