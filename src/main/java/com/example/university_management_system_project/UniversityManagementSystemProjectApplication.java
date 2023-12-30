package com.example.university_management_system_project;

import com.example.university_management_system_project.service.IStudentService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UniversityManagementSystemProjectApplication
        implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(UniversityManagementSystemProjectApplication.class, args);
    }

    public UniversityManagementSystemProjectApplication(IStudentService studentService) {
        this.studentService = studentService;
    }

    private final IStudentService studentService;

    @Override
    public void run(String... args) throws Exception {
//        studentService.save(new Student(2387438, 83048,"User1","Password1"));
//        studentService.save(new Student(238538, 83548,"User2","Password2"));
//        studentService.save(new Student(2345438, 832348,"User3","Password3"));
    }
}
