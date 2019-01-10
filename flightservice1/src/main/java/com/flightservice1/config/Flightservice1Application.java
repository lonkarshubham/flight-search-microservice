package com.flightservice1.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.flightservice1.repository")
@ComponentScan(basePackages = "com.flightservice1.*")
@EntityScan("com.flightservice1.*")
public class Flightservice1Application {

    public static void main(String[] args) {
        SpringApplication.run(Flightservice1Application.class, args);
    }
}

