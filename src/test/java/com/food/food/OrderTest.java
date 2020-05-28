package com.food.food;

import com.food.mappers.OrderFormMapper;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Log4j2
public class OrderTest {

@Autowired
    OrderFormMapper mapper;

    @Test
    void contextLoads() {
        long l = mapper.selectOrderCode();
        System.out.println(l);


    }



}
