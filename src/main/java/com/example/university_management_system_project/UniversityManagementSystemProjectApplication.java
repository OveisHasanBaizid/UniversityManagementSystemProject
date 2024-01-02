package com.example.university_management_system_project;

import com.example.university_management_system_project.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
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
