package com.lvdo.exercise.product.message;

import lombok.Getter;

/**
 * 
 * @author lvdo
 *
 */
@Getter
public enum Message {

    ERROR_NULL_PARAMETER("ERROR_NULL_PARAMETER", "Parameter can not be null");

    private String code;

    private String msg;

    Message(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
