package com.mink.javaspringnb1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class JavaSpringNb1Application {

    public static void main(String[] args) {
        SpringApplication.run(JavaSpringNb1Application.class, args);
    }

}
