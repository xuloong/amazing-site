package com.xulong.amazingsite.common;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * GlobalExceptionHandler
 *
 * @author xulong
 * @date 2018/7/12
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResponseEntity<String> errorHandler(HttpServletRequest req, Exception e) throws Exception {

        return ResponseEntity.status(BizException.HttpStatus).body(e.getMessage());

    }

}
