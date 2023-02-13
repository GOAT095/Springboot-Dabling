package com.example.demo.student;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private final StudentRepository studentRepository;


    public StudentService(StudentRepository rep) {
        studentRepository = rep;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public Student getStudent(UUID id) {
        return studentRepository.findAllById(id);
    }

    public Optional<Student> create(Student student) {
        Optional<Student> s = studentRepository.findStudentByEmail(student.getEmail());
        if(s.isPresent()){
            throw new IllegalStateException("email already taken !");
        }
        return Optional.of(studentRepository.save(student));
    }

    public Boolean DeleteStudent(UUID id) {
        Boolean b = studentRepository.existsById(id);
        if(!b){
            throw new IllegalStateException("student with id : "+ id + "does not exists");
        }
        return studentRepository.deleteStudentById(id);
    }
    @Transactional
    public Boolean updateStudent(UUID id, String name, String email){
        Student s = studentRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("student with id : " + id + "Not found !"));
        if(name != null && !Objects.equals(s.getName(), name)){
            s.setName(name);
        }
        if(email != null && !Objects.equals(s.getEmail(), email)){
            Optional<Student> student = studentRepository.findStudentByEmail(email);
            if(student.isPresent()){
                throw new IllegalStateException("email already taken !");
            }
            s.setEmail(email);
        }
        return true;
    }
}