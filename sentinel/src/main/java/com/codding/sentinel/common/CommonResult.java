package com.codding.sentinel.common;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Description
 * @Author hgm
 * @Time 2020/10/21 14:43
 */
@Data
@AllArgsConstructor
public class CommonResult {

    private Object data;

    private String message;

    private Integer code;

    public CommonResult(String message, Integer code){
        this.code = code;
        this.message = message;
    }
}
