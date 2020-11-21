package com.lvdo.exercise.product.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}
