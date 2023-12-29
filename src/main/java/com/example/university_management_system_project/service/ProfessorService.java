package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.exception.NotFoundException;
import com.example.university_management_system_project.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService implements IProfessorService {
    private final ProfessorRepository professorRepository;

    public ProfessorService(ProfessorRepository professorRepository) {
        this.professorRepository = professorRepository;
    }

    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    public void delete(Long id) {
        Optional<Professor> optional = professorRepository.findById(id);
        if (optional.isEmpty())
            throw new NotFoundException("Professor Not found.");
        professorRepository.deleteById(id);
    }

    public Professor findById(Long id) {
        Optional<Professor> optional = professorRepository.findById(id);
        if (optional.isEmpty())
            throw new NotFoundException("Professor Not found.");
        return optional.get();
    }

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }
}
