package com.pzy.dao;

import com.pzy.entity.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper  
@Repository
public interface AddressDao {
    public List<Address> listAddressByName(String name);
}
