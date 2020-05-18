package com.food.food;

import com.food.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodApplicationTests {

    @Autowired
    ProductService service;


    @Test
    void contextLoads() {



    }

}
