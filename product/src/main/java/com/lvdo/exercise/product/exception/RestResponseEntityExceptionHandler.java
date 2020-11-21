package com.lvdo.exercise.product.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lvdo
 *
 */
@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler {

    public static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleGlobalError(HttpServletRequest request, BusinessException ex) {
        log.error("Exception occurred : " + request.getRequestURL().toString(), ex);
        ErrorInfo errorInfo = new ErrorInfo();
        errorInfo.setError(ex.getMsg().getMsg());
        return new ResponseEntity<Object>(errorInfo, ex.getCode());
    }
}
