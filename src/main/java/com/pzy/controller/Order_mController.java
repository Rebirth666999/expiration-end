package com.pzy.controller;

import com.alibaba.fastjson.JSON;
import com.pzy.dao.Order_mDao;
import com.pzy.entity.Order_m;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class Order_mController {
    @Autowired
    private Order_mDao order_mDao;

    @GetMapping("/listOrder_m")
    @ResponseBody
    @CrossOrigin
    public List<Order_m> listOrder_m() {
        List<Order_m> listOrder_m = order_mDao.listOrder_mByNo("");
        //System.out.println(JSON.toJSONString(listOrder_m));
        return listOrder_m;
    }

    @PostMapping("/selectOrder_m/{no}")
    @ResponseBody
    @CrossOrigin
    public List<Order_m> selectOrder_m(@PathVariable String no) {
        List<Order_m> listOrder_m = order_mDao.listOrder_mByNo(no);
        //System.out.println(JSON.toJSONString(listOrder_m));
        return listOrder_m;
    }

    @GetMapping("/deleteOrder_m/{id}")
    @ResponseBody
    @CrossOrigin
    public boolean deleteOrder_m(@PathVariable Integer id) {
        order_mDao.deleteOrder_mById(id);
        return true;
    }

    @PostMapping("/addOrder_m")
    @ResponseBody
    @CrossOrigin
    public boolean addOrder_m(@RequestBody Order_m order_m) {
        Integer user_id = order_m.getUser_id();
        String order_no = order_m.getOrder_no();
        String order_date =order_m.getOrder_date();
        String date = order_m.getOrder_date();
        String audio=order_m.getAudit();
        String remark=order_m.getRemark();

        order_m.setUser_id(user_id);
        order_m.setOrder_no(order_no);
        order_m.setOrder_date(order_date);
        order_m.setDate(date);
        order_m.setAudit(audio);
        order_m.setRemark(remark);

        order_mDao.addOrder_m(order_m);

        return true;
    }

    @PostMapping("/updateOrder_m")
    @ResponseBody
    @CrossOrigin
    public boolean updateOrder_m(@RequestBody Order_m order_m) {
        Integer order_id = order_m.getOrder_id();
        Integer user_id = order_m.getUser_id();
        String order_no = order_m.getOrder_no();
        String order_date =order_m.getOrder_date();
        String date = order_m.getOrder_date();
        String audio=order_m.getAudit();
        String remark=order_m.getRemark();

        order_m.setOrder_id(order_id);
        order_m.setUser_id(user_id);
        order_m.setOrder_no(order_no);
        order_m.setOrder_date(order_date);
        order_m.setDate(date);
        order_m.setAudit(audio);
        order_m.setRemark(remark);

        order_mDao.updateOrder_m(order_m);

        return true;
    }
}