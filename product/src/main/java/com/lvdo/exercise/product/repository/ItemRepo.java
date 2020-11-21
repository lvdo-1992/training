package com.lvdo.exercise.product.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lvdo.exercise.product.entity.ItemEntity;

/**
 * 
 * @author lvdo
 *
 */
@Repository
public interface ItemRepo extends PagingAndSortingRepository<ItemEntity, Long> {

}
