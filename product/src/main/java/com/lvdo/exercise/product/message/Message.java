package com.lvdo.exercise.product.message;

import lombok.Getter;

/**
 * 
 * @author lvdo
 *
 */
@Getter
public enum Message {

    ERROR_REQUEST("Error at request"),
    ERROR_PAGE_PARAM("Error page param. {page} must start from 0 and {limit} must start from 1"),
    ERROR_BUY_ITEM_FIND_NOT_FOUND_ITEM("Find not fount item for buying"),
    ERROR_BUY_ITEM_NOT_ENOUGHT("Do not enought item for buying");

    private String msg;

    Message(String msg) {
        this.msg = msg;
    }

}
