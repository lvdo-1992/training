package com.lvdo.exercise.product.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import com.lvdo.exercise.product.dto.ItemDto;
import com.lvdo.exercise.product.entity.ItemEntity;
import com.lvdo.exercise.product.repository.ItemRepo;
import com.lvdo.exercise.product.util.MapperUtil;

/**
 * 
 * @author lvdo
 *
 */
@ExtendWith(MockitoExtension.class)
public class ItemServiceTest {

    @Mock
    private MapperUtil mapperUtil;

    @Mock
    private ItemRepo itemRepo;

    @InjectMocks
    private ItemService itemService;

    @Test
    public void testCreateItem_OK() {
        // Given
        ItemDto dto = new ItemDto();
        ItemDto savedDto = new ItemDto();
        ItemEntity entity = new ItemEntity();
        entity.setSellingPrice(12.345);
        ItemEntity savedData = new ItemEntity();
        when(mapperUtil.convertToEntity(dto, ItemEntity.class)).thenReturn(entity);
        when(itemRepo.save(entity)).thenReturn(savedData);
        when(mapperUtil.convertToDto(savedData, ItemDto.class)).thenReturn(savedDto);

        // When
        ItemDto result = itemService.createItem(dto);

        // Then
        assertNotNull(result);
        assertEquals(savedDto, result);
    }

    @Test
    public void testListAllItems() {
        // Given
        int page = 0;
        Integer limit = 2;
        List<ItemDto> selectedDtos = new LinkedList<ItemDto>();
        List<ItemEntity> content = new LinkedList<ItemEntity>();
        Page<ItemEntity> pageItems = new PageImpl<ItemEntity>(content);
        when(itemRepo.findAll(any(PageRequest.class))).thenReturn(pageItems);
        when(mapperUtil.convertToDto(pageItems.getContent(), ItemDto.class)).thenReturn(selectedDtos);

        // When
        List<ItemDto> result = itemService.listAllItems(page, limit);

        // Then
        assertNotNull(result);
    }

}
