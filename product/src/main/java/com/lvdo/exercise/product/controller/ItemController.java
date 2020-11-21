package com.lvdo.exercise.product.controller;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lvdo.exercise.product.dto.ItemDto;
import com.lvdo.exercise.product.service.ItemService;

/**
 * 
 * @author lvdo
 *
 */
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    /**
     * API for creating a new Item
     * 
     * @param dto ItemDTO from request body
     * @return saved item
     */
    @PostMapping("items")
    public ResponseEntity<ItemDto> createItem(@Validated @RequestBody ItemDto dto) {
        if (!Objects.isNull(dto)) {
            return new ResponseEntity<ItemDto>(itemService.createItem(dto), HttpStatus.CREATED);
        }
        return new ResponseEntity<ItemDto>(HttpStatus.OK);
    }

    /**
     * API for getting all items by page
     * 
     * @param page  first page start by 0
     * @param limit total element of each page, limit must be greater than 0
     * @return list of searched items
     */
    @GetMapping("items")
    public ResponseEntity<List<ItemDto>> listAllItemsByPage(@Validated @RequestParam("page") Integer page,
            @Validated @RequestParam("limit") Integer limit) {
        if (page == null || page < 0 || limit == null || limit == 0) {

        }
        return new ResponseEntity<List<ItemDto>>(itemService.listAllItems(page, limit), HttpStatus.OK);
    }

}
