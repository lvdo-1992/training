package com.lvdo.exercise.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lvdo.exercise.product.dto.ItemDto;
import com.lvdo.exercise.product.service.ItemService;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("items")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto dto) {
        
        return new ResponseEntity<ItemDto>(HttpStatus.OK);
    }

}
