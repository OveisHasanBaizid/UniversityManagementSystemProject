package com.example.university_management_system_project.controller;

import com.example.university_management_system_project.dto.CourseDTO;
import com.example.university_management_system_project.dto.StudentDTO;
import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.exception.NotFoundException;
import com.example.university_management_system_project.mapper.CourseMapper;
import com.example.university_management_system_project.mapper.ProfessorMapper;
import com.example.university_management_system_project.mapper.StudentMapper;
import com.example.university_management_system_project.service.CourseService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

    @MockBean
    private CourseService courseService;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CourseMapper courseMapper;

    @MockBean
    private StudentMapper studentMapper;

    @MockBean
    private ProfessorMapper professorMapper;

    @Autowired
    private ObjectMapper objectMapper;

    private Course course;
    private CourseDTO courseDTO;

    @BeforeEach
    public void setUp() {
        course = new Course();
        course.setId(1L);
        course.setCode(1);

        courseDTO = new CourseDTO();
        courseDTO.setId(1L);
        courseDTO.setCode(1);
    }

    @Test
    void shouldReturnOkForSave() throws Exception {
        when(courseService.save(course)).thenReturn(course);
        mockMvc.perform(post("/course/v1/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(courseDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnOkForUpdate() throws Exception {
        course.setTitle("Course1");
        when(courseService.update(course)).thenReturn(course);
        mockMvc.perform(put("/course/v1/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(courseDTO)))
                .andExpect(status().isOk());
    }

    @Test
    void shouldThrowExceptionForUpdate() throws Exception {
        when(courseService.update(any())).thenThrow(NotFoundException.class);
        mockMvc.perform(put("/course/v1/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(courseDTO)))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldReturnOkForDeleteById() throws Exception {
        Long id = 1L;
        doNothing().when(courseService).deleteById(id);
        mockMvc.perform(delete("/course/v1/delete/{id}", id)).andExpect(status().isOk());
    }

    @Test
    void shouldThrowExceptionForFindById() throws Exception {
        doThrow(NotFoundException.class).when(courseService).findById(1L);
        doNothing().when(courseService).deleteById(any());
        Long id = 1L;
        mockMvc.perform(get("/course/v1/find/{id}", id)).andExpect(status().isNotFound());
    }

    @Test
    void findAllReturnNull() throws Exception {
        when(courseService.findAll()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/course/v1/list"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(0))
                .andDo(print());
    }

    @Test
    void listStudentsCourse() throws Exception {
        List<Student> students = new ArrayList<>();
        students.add(new Student());

        List<StudentDTO> studentDTOS = new ArrayList<>();
        studentDTOS.add(new StudentDTO());

        when(courseService.listStudents(1)).thenReturn(students);
        when(studentMapper.toStudentDTOs(students)).thenReturn(studentDTOS);

        mockMvc.perform(get("/course/v1/{codeCourse}/students", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(students.size()))
                .andDo(print());

    }

    @Test
    void addStudent() {
    }

    @Test
    void removeStudent() {
    }

    @Test
    void addProfessor() {
    }

    @Test
    void testRemoveStudent() {
    }

    @Test
    void getProfessor() {
    }
}