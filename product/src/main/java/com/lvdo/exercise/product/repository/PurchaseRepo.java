package com.lvdo.exercise.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvdo.exercise.product.entity.PurchaseEntity;

@Repository
public interface PurchaseRepo extends CrudRepository<PurchaseEntity, Long> {

}
