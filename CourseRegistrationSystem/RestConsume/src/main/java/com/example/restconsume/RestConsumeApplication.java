package com.example.restconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.restconsume")
public class RestConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestConsumeApplication.class, args);
    }

}
