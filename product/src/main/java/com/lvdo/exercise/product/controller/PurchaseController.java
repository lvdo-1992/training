package com.lvdo.exercise.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvdo.exercise.product.dto.PurchaseDto;
import com.lvdo.exercise.product.service.PurchaseService;

/**
 * 
 * @author lvdo
 *
 */
@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    /**
     * API for buying a item
     * 
     * @param itemId   item id
     * @param quantity quantity of buying item
     * @return bought item
     */
    @PostMapping("buy/{item_id}")
    public ResponseEntity<PurchaseDto> buyItem(@Validated @PathVariable("item_id") Long itemId,
            @Validated @RequestBody(required = true) PurchaseDto purchaseDto) {
        Integer quantity = purchaseDto.getQuantity();
        return new ResponseEntity<PurchaseDto>(purchaseService.buyItem(itemId, quantity), HttpStatus.CREATED);
    }

}
