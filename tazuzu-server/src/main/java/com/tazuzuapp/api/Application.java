package com.tazuzuapp.api;

import com.tazuzuapp.api.security.JwtUtil;
import com.tazuzuapp.api.security.filter.JwtFilter;
import com.tazuzuapp.api.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
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

    @Bean
    @Autowired
    public FilterRegistrationBean jwtFilterRegistration(JwtUtil jwtUtil, UserService userService) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new JwtFilter(jwtUtil, userService));

        filterRegistrationBean.addUrlPatterns("/*");

        // ordering in the filter chain
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

}