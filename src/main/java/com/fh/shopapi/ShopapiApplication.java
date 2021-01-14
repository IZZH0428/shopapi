package com.fh.shopapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.fh.shopapi.dao")
public class ShopapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopapiApplication.class, args);
    }

}
