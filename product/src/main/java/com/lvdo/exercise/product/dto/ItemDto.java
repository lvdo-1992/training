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
public class ItemDto extends AbstractDto {

    /**
     * 
     */
    private static final long serialVersionUID = 3846508432570237600L;

    @JsonProperty("total_stock_value")
    private Integer totalStockValue;

    @JsonProperty("current_stock_value")
    private Integer currentStockValue;

    @JsonProperty("selling_price")
    private Double sellingPrice;

    @JsonProperty("place_at")
    @JsonFormat(shape = JsonFormat.Shape.NUMBER, pattern = "s")
    private Date placeAt;

    @Override
    public String toString() {
        return "ItemDto [totalStockValue=" + totalStockValue + ", currentStockValue=" + currentStockValue
                + ", sellingPrice=" + sellingPrice + ", placeAt=" + placeAt + ", getId()=" + getId() + "]";
    }

}
