package com.example.appnewssite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
public class AppNewsSiteApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppNewsSiteApplication.class, args);
    }

}
