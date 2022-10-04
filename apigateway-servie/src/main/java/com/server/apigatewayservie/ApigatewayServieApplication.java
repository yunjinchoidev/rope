package com.server.apigatewayservie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
public class ApigatewayServieApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApigatewayServieApplication.class, args);
    }

}
