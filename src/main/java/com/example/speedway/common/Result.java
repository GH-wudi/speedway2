package com.example.speedway.common;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
@JsonPropertyOrder({"code","msg","data"})
public class Result<T> {
    private Integer code; // 200: 成功, 500: 失败
    private String msg;   // 提示信息
    private T data;       // 真正的数据 (比如 GeoJSON)

    // 成功时的快捷方法
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.msg = "操作成功";
        result.data = data;
        return result;
    }

    // 失败时的快捷方法
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 500;
        result.msg = msg;
        return result;
    }
}