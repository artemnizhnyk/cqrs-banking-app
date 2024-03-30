package com.artemnizhnyk.cqrsbankingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class CqrsBankingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CqrsBankingAppApplication.class, args);
    }

}
