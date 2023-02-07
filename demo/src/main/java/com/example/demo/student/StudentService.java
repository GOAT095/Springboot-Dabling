package com.example.demo.student;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(new Student(1L,
                "hamid",
                "hamid.dwada@mail.com",
                LocalDate.of(2000, Month.JANUARY, 1),
                23));
    }
}
