package com.springboot.mongodb.repository;

import com.springboot.mongodb.domain.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description
 * @Author hgm
 * @Time 2020/9/27 18:00
 */
@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
}
