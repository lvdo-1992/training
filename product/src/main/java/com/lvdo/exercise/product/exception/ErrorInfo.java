package com.lvdo.exercise.product.exception;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author lvdo
 *
 */
@Getter
@Setter
public class ErrorInfo implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5799573058095311944L;

    @JsonProperty("error")
    private String error;

}
