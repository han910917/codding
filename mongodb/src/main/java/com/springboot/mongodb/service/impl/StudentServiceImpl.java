package com.springboot.mongodb.service.impl;

import com.springboot.mongodb.domain.Student;
import com.springboot.mongodb.repository.StudentRepository;
import com.springboot.mongodb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Description
 * @Author hgm
 * @Time 2020/9/27 18:02
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Optional<Student> getStudent(String id) {
        return studentRepository.findById(id);
    }
}
