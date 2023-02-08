package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

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

    public Student create(Student student) {
        return studentRepository.save(student);
    }
}
