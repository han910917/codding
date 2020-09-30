package com.springboot.mongodb.service;

import com.springboot.mongodb.domain.Student;

import java.util.Optional;

/**
 * @Description
 * @Author hgm
 * @Time 2020/9/27 18:01
 */
public interface StudentService {

    Student addStudent(Student student);

    Optional<Student> getStudent(String id);
}
