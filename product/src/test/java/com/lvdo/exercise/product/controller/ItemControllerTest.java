package com.lvdo.exercise.product.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

import com.lvdo.exercise.product.dto.ItemDto;

/**
 * 
 * @author lvdo
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")
public class ItemControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testCreateItem_OK() {
        // Given
        ItemDto requestObj = new ItemDto();
        requestObj.setSellingPrice(75.4);
        requestObj.setTotalStockValue(100);

        // When
        ResponseEntity<ItemDto> response = restTemplate.postForEntity("/items", requestObj, ItemDto.class);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        ItemDto result = response.getBody();
        assertNotNull(result);
        assertEquals(75.4, result.getSellingPrice());
        assertEquals(100, result.getCurrentStockValue());
        assertEquals(100, result.getTotalStockValue());
    }

    @Test
    public void testCreateItem_Error_PRECONDITION_REQUIRED() {
        // Given
        ItemDto requestObj = new ItemDto();
        requestObj.setSellingPrice(75.4);

        // When
        ResponseEntity<Object> response = restTemplate.postForEntity("/items", requestObj, Object.class);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.PRECONDITION_REQUIRED, response.getStatusCode());
    }

    @SuppressWarnings("rawtypes")
    @Test
    public void testListAllItemsByPage_OK() {
        // Given
        Integer page = 0;
        Integer limit = 2;
        String url = "/items?page=" + page + "&limit=" + limit;
        ItemDto requestObj = new ItemDto();
        requestObj.setSellingPrice(75.4);
        requestObj.setTotalStockValue(100);
        for (int i = 0; i < 4; i++) {
            restTemplate.postForEntity("/items", requestObj, ItemDto.class);
        }

        // When
        ResponseEntity<List> response = restTemplate.getForEntity(url, List.class);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        List result = response.getBody();
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testListAllItemsByPage_ERROR_PAGE_PARAM() {
        // Given
        Integer page = -1;
        Integer limit = 2;
        String url = "/items?page=" + page + "&limit=" + limit;

        // When
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.PRECONDITION_REQUIRED, response.getStatusCode());
    }

}
