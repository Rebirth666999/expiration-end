package com.pzy.controller;

import com.alibaba.fastjson.JSON;
import com.pzy.dao.AddressDao;
import com.pzy.entity.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AddressController {
    @Autowired
    private AddressDao addressDao;

    @GetMapping("/listAddress")
    @ResponseBody
    @CrossOrigin
    public List<Address> listAddress() {
        List<Address> listAddress = addressDao.listAddressByName("");
        //System.out.println(JSON.toJSONString(listAddress));
        return listAddress;
    }

    @PostMapping("/selectAddress/{name}")
    @ResponseBody
    @CrossOrigin
    public List<Address> selectAddress(@PathVariable String name) {
        List<Address> listAddress = addressDao.listAddressByName(name);
        //System.out.println(JSON.toJSONString(listAddress));
        return listAddress;
    }
}
