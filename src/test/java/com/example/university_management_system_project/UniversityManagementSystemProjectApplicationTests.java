package com.example.university_management_system_project;

import com.example.university_management_system_project.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class UniversityManagementSystemProjectApplicationTests {
    @Autowired
    private StudentService studentService;
    @Test
    void contextLoads() {
        int size = studentService.findAll().size();
        assertThat(size).isEqualTo(3);
    }

}
