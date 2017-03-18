package com.tazuzuapp.api;

import com.tazuzuapp.api.activity.domain.Activity;
import com.tazuzuapp.api.user.domain.Student;
import com.tazuzuapp.api.user.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;
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