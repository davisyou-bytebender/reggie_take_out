package com.alibaba.reggie.common;

import com.baomidou.mybatisplus.extension.api.R;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author davis you
 * @Date 2022/4/22 3:52 PM
 * @Version 1.0
 */
@Data
public class Result <T>{
    private Integer code;  // 编码 1成功 0和其他数字是失败
    private String msg;  // 错误信息
    private T data;  //数据
    private Map map = new HashMap();  //动态数据


    public static <T> Result<T> success(T object){
        Result<T> result = new Result<>();
        result.data = object;
        result.code = 1;
        return result;
    }

    public static <T> Result<T> error(String msg){

        Result<T> result = new Result<>();
        result.code = 0;
        result.msg = msg;
        return result;
    }


    public Result<T> add(String key, String value) {
        this.map.put(key, value);
        return this;
    }

}
