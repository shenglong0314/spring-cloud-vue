package com.glf.eurake.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurakeServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(EurakeServiceApp.class,args);
    }
}
