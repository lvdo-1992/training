package com.lvdo.exercise.product.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author lvdo
 *
 */
@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemEntity implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 7139273723170544512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "total_stock_value")
    private Integer totalStockValue;

    @Column(name = "current_stock_value")
    private Integer currentStockValue;

    @Column(name = "selling_price", columnDefinition = "Decimal(10,2) default '0.00'")
    private Double sellingPrice;

    @Column(name = "place_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date placeAt;

    @Override
    public String toString() {
        return "ItemEntity [totalStockValue=" + totalStockValue + ", currentStockValue=" + currentStockValue
                + ", sellingPrice=" + sellingPrice + ", placeAt=" + placeAt + ", getId()=" + getId() + "]";
    }

}
