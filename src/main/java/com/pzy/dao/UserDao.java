package com.pzy.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.pzy.entity.User;

import java.util.List;

@Mapper  // 告诉springboot这是一个mybatis的mapper类
@Repository   // 将userdao交由spring容齐管理
public interface UserDao {
    public List<User> listUserByName(String name);
}
