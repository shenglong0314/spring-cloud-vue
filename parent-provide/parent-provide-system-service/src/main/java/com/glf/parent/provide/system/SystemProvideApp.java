package com.glf.parent.provide.system;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import tk.mybatis.spring.annotation.MapperScan;



@EnableEurekaClient
@MapperScan("com.glf.parent.provide.system.dao")
@SpringBootApplication
@EnableCircuitBreaker
public class SystemProvideApp {

      public static void main(String[] args) {
          SpringApplication.run(SystemProvideApp.class,args);


    }
}
