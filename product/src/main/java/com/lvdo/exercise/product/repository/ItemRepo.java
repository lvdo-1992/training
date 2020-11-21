package com.lvdo.exercise.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvdo.exercise.product.entity.ItemEntity;

@Repository
public interface ItemRepo extends CrudRepository<ItemEntity, Long> {

}
