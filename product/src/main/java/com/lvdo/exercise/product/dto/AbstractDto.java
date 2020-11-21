package com.lvdo.exercise.product.dto;

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
public class AbstractDto implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4284308360616005962L;

    @JsonProperty("id")
    private Long id;

}
