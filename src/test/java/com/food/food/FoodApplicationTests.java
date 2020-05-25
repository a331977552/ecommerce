package com.food.food;

import com.food.service.IProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodApplicationTests {

    @Autowired
    IProductService service;


    @Test
    void contextLoads() {



    }

}
