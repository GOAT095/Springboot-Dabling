package com.example.demo.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;



    public StudentService(StudentRepository rep)
    {
        studentRepository = rep;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public Student getStudent(UUID id){
        return studentRepository.findAllById(id);
    }
    public Student create(Student student) {
        return studentRepository.save(student);
    }
}
