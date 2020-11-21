package com.lvdo.exercise.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvdo.exercise.product.repository.ItemRepo;

@Service
public class ItemService {

    @Autowired
    private ItemRepo itemRepo;

}
