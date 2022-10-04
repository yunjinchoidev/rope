package com.server.catalogservie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CatalogServieApplication {

    public static void main(String[] args) {
        SpringApplication.run(CatalogServieApplication.class, args);
    }

}
