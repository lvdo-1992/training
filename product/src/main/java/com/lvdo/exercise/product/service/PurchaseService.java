package com.lvdo.exercise.product.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvdo.exercise.product.dto.PurchaseDto;
import com.lvdo.exercise.product.entity.ItemEntity;
import com.lvdo.exercise.product.entity.PurchaseEntity;
import com.lvdo.exercise.product.repository.ItemRepo;
import com.lvdo.exercise.product.repository.PurchaseRepo;
import com.lvdo.exercise.product.util.MapperUtil;

/**
 * 
 * @author lvdo
 *
 */
@Service
public class PurchaseService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private PurchaseRepo purchaseRepo;

    @Autowired
    private MapperUtil mapperUtil;

    public PurchaseDto buyItem(Long itemId, Integer quantity) {
        Optional<ItemEntity> optional = itemRepo.findById(itemId);
        if (optional.isPresent()) {
            ItemEntity itemEntity = optional.get();
            Integer available = (int) (itemEntity.getCurrentStockValue() / itemEntity.getSellingPrice());
            if (quantity <= available) {
                itemEntity.setCurrentStockValue(itemEntity.getTotalStockValue() - quantity);

                PurchaseEntity purchaseEntity = new PurchaseEntity();
                purchaseEntity.setBoughtAt(new Date());
                purchaseEntity.setItemEntity(itemEntity);
                purchaseEntity.setQuantity(quantity);

                return mapperUtil.convertToDto(purchaseRepo.save(purchaseEntity), PurchaseDto.class);
            } else {

            }
        }
        return null;
    }

}
