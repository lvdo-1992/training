package com.lvdo.exercise.product.service;

import java.util.Date;
import java.util.Objects;
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
        if (Objects.nonNull(itemId) && Objects.nonNull(quantity)) {
            Optional<ItemEntity> optional = itemRepo.findById(itemId);
            if (optional.isPresent()) {
                ItemEntity itemEntity = optional.get();
                Double price = itemEntity.getSellingPrice();
                Integer currentValue = itemEntity.getCurrentStockValue();
                Integer buyValue = (int) (quantity * price);
                if (currentValue >= buyValue) {
                    itemEntity.setCurrentStockValue(currentValue - buyValue);

                    PurchaseEntity purchaseEntity = new PurchaseEntity();
                    purchaseEntity.setBoughtAt(new Date());
                    purchaseEntity.setItemEntity(itemEntity);
                    purchaseEntity.setQuantity(quantity);

                    return mapperUtil.convertToDto(purchaseRepo.save(purchaseEntity), PurchaseDto.class);
                } else {

                }
            }
        }
        return null;
    }

}
