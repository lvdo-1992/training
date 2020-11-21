package com.lvdo.exercise.product.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import com.lvdo.exercise.product.dto.PurchaseDto;

/**
 * 
 * @author lvdo
 *
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.yml")
@ActiveProfiles("test")
public class PurchaseControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testBuyItem_OK() {
        // Given
        ItemDto dumpRequestObj = new ItemDto();
        dumpRequestObj.setSellingPrice(15.4);
        dumpRequestObj.setTotalStockValue(100);
        ResponseEntity<ItemDto> dumpResponse = restTemplate.postForEntity("/items", dumpRequestObj, ItemDto.class);
        Long itemId = dumpResponse.getBody().getId();
        String url = "/buy/" + itemId;

        PurchaseDto requestObj = new PurchaseDto();
        requestObj.setQuantity(3);

        // When
        ResponseEntity<PurchaseDto> response = restTemplate.postForEntity(url, requestObj, PurchaseDto.class);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        PurchaseDto result = response.getBody();
        assertNotNull(result);
    }

    @Test
    public void testBuyItem_ERROR_BUY_ITEM_NOT_ENOUGHT() {
        // Given
        ItemDto dumpRequestObj = new ItemDto();
        dumpRequestObj.setSellingPrice(75.4);
        dumpRequestObj.setTotalStockValue(100);
        ResponseEntity<ItemDto> dumpResponse = restTemplate.postForEntity("/items", dumpRequestObj, ItemDto.class);
        Long itemId = dumpResponse.getBody().getId();
        String url = "/buy/" + itemId;

        PurchaseDto requestObj = new PurchaseDto();
        requestObj.setQuantity(3);

        // When
        ResponseEntity<Object> response = restTemplate.postForEntity(url, requestObj, Object.class);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.PRECONDITION_REQUIRED, response.getStatusCode());
    }

    @Test
    public void testBuyItem_PRECONDITION_REQUIRED() {
        // Given
        String url = "/buy/1";
        PurchaseDto requestObj = new PurchaseDto();

        // When
        ResponseEntity<Object> response = restTemplate.postForEntity(url, requestObj, Object.class);

        // Then
        assertNotNull(response);
        assertEquals(HttpStatus.PRECONDITION_REQUIRED, response.getStatusCode());
    }

}
