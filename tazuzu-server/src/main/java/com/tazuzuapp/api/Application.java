package com.tazuzuapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

/**
 * SpringBoot Main Application:
 * Sets up default configuration, starts spring application context (containers),
 * performs class path scan (service, webController annotations etc.) and starts Tomcat server
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
        SpringApplication app = new SpringApplication(Application.class);
        app.run();
    }
}