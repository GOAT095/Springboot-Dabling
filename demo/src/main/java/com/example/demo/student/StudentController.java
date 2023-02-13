package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable UUID id){return studentService.getStudent(id);}

    @GetMapping()
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping()
    public Optional<Student> createStudent(@RequestBody Student student)
    {
        return studentService.create(student);
    }

    @PutMapping("{id}")
    public Boolean updateStudent(@PathVariable UUID id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        studentService.updateStudent(id, name, email);
        return true;
    }
    @DeleteMapping("{id}")
    public Boolean DeleteStudent(@PathVariable UUID id){

        return studentService.DeleteStudent(id);
    }
}
