package com.pzy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication//这行代码是一个注解，它标记在类上，表示这是一个Spring Boot的应用程序。
// @SpringBootApplication是一个方便的注解，它包含了@Configuration、@EnableAutoConfiguration、@ComponentScan。
public class SpringbootMybatisApplication {//这行代码定义了一个公开的类SpringbootMybatisApplication。
    // 这是Spring Boot应用程序的主类，也是程序的入口点。

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisApplication.class, args);
    }//SpringbootMybatisApplication类。这个类通常会被@SpringBootApplication注解标记，表示它是一个Spring Boot应用的主类。

}
