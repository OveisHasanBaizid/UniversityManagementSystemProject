package com.example.university_management_system_project;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@Slf4j
@SpringBootApplication
@EnableCaching
public class UniversityManagementSystemProjectApplication
        implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementSystemProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.error("Hi");
    }
}
