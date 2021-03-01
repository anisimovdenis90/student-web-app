package com.anisimovdenis.services;

import com.anisimovdenis.entities.Student;
import com.anisimovdenis.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public boolean existsById(Long id) {
        return studentRepository.existsById(id);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
