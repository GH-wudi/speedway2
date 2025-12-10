package com.example.speedway.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice // 核心注解：拦截所有 Controller 的异常
public class GlobalExceptionHandler {

    // 1. 拦截我们自己抛出的业务异常
    @ExceptionHandler(ServiceException.class)
    public Result<?> handleServiceException(ServiceException e) {
        log.error("业务异常: {}", e.getMessage());
        return Result.error(e.getMessage());
    }

    // 2. 拦截所有未知的系统异常（比如空指针、数据库连不上）
    @ExceptionHandler(Exception.class)
    public Result<?> handleException(Exception e) {
        log.error("系统内部异常", e); // 打印堆栈到控制台，方便排查
        return Result.error("系统繁忙，请联系管理员"); // 给前端返回友好的提示
    }
}