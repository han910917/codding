package com.springboot.mongodb.controller;

import com.springboot.mongodb.domain.Student;
import com.springboot.mongodb.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @Description
 * @Author hgm
 * @Time 2020/9/27 18:05
 */
@Api(tags = "StudentController", description = "mongodb测试")
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiOperation("添加品牌")
    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @ApiOperation("获取数据")
    @PostMapping("/get")
    @ResponseBody
    public Optional<Student> getStudent(String id){
        return studentService.getStudent(id);
    }
}
