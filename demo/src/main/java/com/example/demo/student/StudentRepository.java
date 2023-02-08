package com.example.demo.student;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface StudentRepository extends CrudRepository<Student , UUID> {
    List<Student> findAll();
}
