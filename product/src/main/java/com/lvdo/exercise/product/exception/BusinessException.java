package com.lvdo.exercise.product.exception;

import org.springframework.http.HttpStatus;

import com.lvdo.exercise.product.message.Message;

import lombok.Getter;

/**
 * 
 * @author lvdo
 *
 */
@Getter
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Message msg;
    private HttpStatus code;

    public BusinessException(Message message, HttpStatus httpStatus) {
        this.msg = message;
        this.code = httpStatus;
    }

}
