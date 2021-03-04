package com.zjm.rizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.zjm.rizhi.dao")
public class RizhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RizhiApplication.class, args);
    }

}
