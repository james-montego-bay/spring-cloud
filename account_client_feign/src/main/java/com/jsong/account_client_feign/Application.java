package com.jsong.account_client_feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableFeignClients(basePackageClasses=com.jsong.account_client_feign.AccountServiceClient.class)
@Configuration
@ComponentScan({"com.jsong.account_client_feign"})

public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
