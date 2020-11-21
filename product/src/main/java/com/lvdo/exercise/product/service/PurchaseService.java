package com.lvdo.exercise.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvdo.exercise.product.repository.PurchaseRepo;

@Service
public class PurchaseService {

    @Autowired
    private PurchaseRepo purchaseRepo;

}
