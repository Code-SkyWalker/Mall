package com.skywalker.pms.exception;

import com.skywalker.entity.Result;
import com.skywalker.enums.BizCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Code SkyWalker
 * @Date 11:53 2022/12/14
 * @Classname GlobalControllerAdvice
 * @Description TODO
 */
@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Result handleException(MethodArgumentNotValidException e) {
        log.error(BizCode.VALID_EXCEPTION.getMsg(), e.getMessage(), e.getClass());

        Map<String, String> errorMap = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach((error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        }));

        return Result.error(BizCode.VALID_EXCEPTION.getCode(), BizCode.VALID_EXCEPTION.getMsg()).put("data", errorMap);
    }

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result handleException(Exception e) {
        log.error("Error:", e);
        return Result.error(BizCode.UNKNOWN_EXCEPTION.getCode(), BizCode.UNKNOWN_EXCEPTION.getMsg());
    }
}
