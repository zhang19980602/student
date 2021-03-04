package com.zjm.rizhi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RizhiApplication {

    public static void main(String[] args) {
        SpringApplication.run(RizhiApplication.class, args);
    }

}
