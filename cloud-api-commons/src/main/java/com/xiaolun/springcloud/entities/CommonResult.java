package com.xiaolun.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor //返回前端通用的json实体块
public class CommonResult<T> {
    //404 not found
    private Integer code; //类似404的一个编码，先判断是否为200
    private String message; //传递的消息(success)
    private T date; //数据

    //有可能data为空。
    public CommonResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
