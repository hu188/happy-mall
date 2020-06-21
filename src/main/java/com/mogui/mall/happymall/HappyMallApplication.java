package com.mogui.mall.happymall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.mogui.mall.happymall.config")
public class HappyMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappyMallApplication.class, args);
    }

}
