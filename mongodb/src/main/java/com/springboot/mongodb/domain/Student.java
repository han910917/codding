package com.springboot.mongodb.domain;

import com.sun.istack.internal.NotNull;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(value = "名称")
    private String name;

    private String gender;
}
