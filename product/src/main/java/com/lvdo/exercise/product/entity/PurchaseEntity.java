package com.lvdo.exercise.product.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "purchase")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class PurchaseEntity extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 3675832665046625321L;

    @ManyToOne
    @JoinColumn(name = "item_id")
    private ItemEntity itemEntity;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "bought_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date boughtAt;

}
