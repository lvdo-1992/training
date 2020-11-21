package com.lvdo.exercise.product.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "item")
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ItemEntity extends BaseEntity {

    /**
     * 
     */
    private static final long serialVersionUID = 7139273723170544512L;

}
