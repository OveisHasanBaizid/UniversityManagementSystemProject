package com.example.university_management_system_project.service;

import com.example.university_management_system_project.entity.Student;
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
        return studentRepository.save(student);
    }

    public void delete(Long id) {
        Optional<Student> optional = studentRepository.findById(id);
        if (optional.isEmpty())
            throw new NotFoundException("Student Not found.");
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
