package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Professor;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.exception.ConflictException;
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
        Optional<Professor> optional;

        //It checks if this National Code already exists or not
        optional = professorRepository.findByNationalCode(professor.getNationalCode());
        if (optional.isPresent())
            throw new ConflictException("The professor with the desired National Code is available in the system.");

        optional = professorRepository.findByUsername(professor.getUsername());
        if (optional.isPresent())
            throw new ConflictException("The professor with the desired username is available in the system.");

        return professorRepository.save(professor);
    }

    @Override
    public Professor update(Professor professor) {
        findById(professor.getId());
        return professorRepository.save(professor);
    }

    public void deleteById(Long id) {
        findById(id);
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
