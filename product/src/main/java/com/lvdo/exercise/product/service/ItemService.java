package com.lvdo.exercise.product.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.lvdo.exercise.product.dto.ItemDto;
import com.lvdo.exercise.product.entity.ItemEntity;
import com.lvdo.exercise.product.repository.ItemRepo;
import com.lvdo.exercise.product.util.MapperUtil;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author lvdo
 *
 */
@Service
@Slf4j
public class ItemService {

    @Autowired
    private MapperUtil mapperUtil;

    @Autowired
    private ItemRepo itemRepo;

    public ItemDto createItem(ItemDto dto) {
        ItemEntity entity = mapperUtil.convertToEntity(dto, ItemEntity.class);
        entity.setCurrentStockValue(entity.getTotalStockValue());
        entity.setSellingPrice(Double.parseDouble(String.format("%.2f", entity.getSellingPrice())));
        entity.setPlaceAt(new Date());

        ItemEntity savedData = itemRepo.save(entity);
        ItemDto itemDto = mapperUtil.convertToDto(savedData, ItemDto.class);
        log.info("Save item" + savedData + " successfully");

        return itemDto;
    }

    public List<ItemDto> listAllItems(int page, Integer limit) {
        Page<ItemEntity> items = itemRepo.findAll(PageRequest.of(page, limit, Sort.by("id")));
        return mapperUtil.convertToDto(items.getContent(), ItemDto.class);
    }

}
