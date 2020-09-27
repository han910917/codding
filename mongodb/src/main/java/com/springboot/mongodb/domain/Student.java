package com.springboot.mongodb.domain;

import com.sun.istack.internal.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * @Description
 * @Author hgm
 * @Time 2020/9/27 17:58
 */
@Data
public class Student {

    @Id
    private String id;

    @NotNull
    private String studentId;

    private Integer age;

    private String name;

    private String gender;
}
