package com.lvdo.exercise.product;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.yml")
class ProductApplicationTests {

    @Test
    void contextLoads() {
    }

}
