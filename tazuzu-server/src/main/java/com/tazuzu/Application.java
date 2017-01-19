package com.tazuzu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EntityScan("com.tazuzu")
@EnableJpaRepositories("com.tazuzu.services")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}