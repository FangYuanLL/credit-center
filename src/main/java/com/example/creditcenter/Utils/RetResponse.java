package com.example.creditcenter.Utils;

/**
 * 使用result风格返回数据有两种方式
 * 1.对数据进行pack打包成对应的数据
 * 2.@ResponseBodyAdvice以及@ControllerAdvice注解定义返回切面
 *
 */
public class RetResponse {

    public static <T> Result<T> pack(int code, String msg,T data){
        return new Result<T>(code,msg,data);
    }
}
