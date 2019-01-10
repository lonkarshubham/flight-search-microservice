package com.flightservice2.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories(basePackages = "com.flightservice2.repository")
@ComponentScan(basePackages = "com.flightservice2.*")
@EntityScan("com.flightservice2.*")
public class FlightService2Application {

    public static void main(String[] args) {
        SpringApplication.run(FlightService2Application.class, args);
    }
}

