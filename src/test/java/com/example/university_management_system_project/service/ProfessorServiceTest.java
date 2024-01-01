package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.repository.ProfessorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProfessorServiceTest {

    @Mock
    private ProfessorRepository professorRepository;

    @InjectMocks
    private ProfessorService professorService;

    static Professor professor;

    @BeforeAll
    public static void createObject() {
        professor = new Professor();
        professor.setId(1L);
        professor.setCode(1);
    }

    @Test
    void update() {

        when(professorRepository.findById(1L)).thenReturn(Optional.of(professor));
        when(professorRepository.save(professor)).thenReturn(professor);

        professor.setCode(2);

        Professor professor1 = professorService.update(professor);

        Assertions.assertSame(2, professor1.getCode());
    }
}