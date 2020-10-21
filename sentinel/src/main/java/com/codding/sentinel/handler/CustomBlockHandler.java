package com.codding.sentinel.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.codding.sentinel.common.CommonResult;

/**
 * @Description
 * @Author hgm
 * @Time 2020/10/21 14:57
 */
public class CustomBlockHandler {

    public CommonResult handleException(Exception exception){
        System.out.println(14);
        return new CommonResult("自定义限流信息", 200);
    }
}
