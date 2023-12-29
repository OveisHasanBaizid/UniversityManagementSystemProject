package com.example.university_management_system_project.service;

import com.example.university_management_system_project.dto_mapper.StudentDTO;
import com.example.university_management_system_project.entity.Course;
import com.example.university_management_system_project.entity.Student;
import com.example.university_management_system_project.exception.ConflictException;
import com.example.university_management_system_project.exception.NotFoundException;
import com.example.university_management_system_project.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        Optional<Student> optional;

        //It checks if this National Code already exists or not
        optional = studentRepository.findByNationalCode(student.getNationalCode());
        if (optional.isPresent())
            throw new ConflictException("The student with the desired National Code is available in the system.");

        optional = studentRepository.findByUsername(student.getUsername());
        if (optional.isPresent())
            throw new ConflictException("The student with the desired username is available in the system.");

        return studentRepository.save(student);
    }

    @Override
    public Student update(Student student) {
        findById(student.getId());
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        findById(id);
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
            if (optional.isEmpty())
                throw new NotFoundException("Student Not found.");
        return optional.get();
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
