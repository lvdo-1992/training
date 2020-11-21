package com.lvdo.exercise.product.exception;

/**
 * 
 * @author lvdo
 *
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private final String message;
    private final String[] args;

    public BusinessException(String message, String... args) {
        this.message = message;
        this.args = args;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String[] getArgs() {
        return args;
    }
}
