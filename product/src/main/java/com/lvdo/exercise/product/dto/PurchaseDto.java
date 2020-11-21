package com.lvdo.exercise.product.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
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
public class PurchaseDto extends AbstractDto {
    /**
    * 
    */
    private static final long serialVersionUID = -1077192983180561188L;

    @JsonProperty("item_id")
    private Long itemId;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("bought_at")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "s")
    private Date boughtAt;

    @Override
    public String toString() {
        return "PurchaseDto [itemId=" + itemId + ", quantity=" + quantity + ", boughtAt=" + boughtAt + ", getId()="
                + getId() + "]";
    }

}
