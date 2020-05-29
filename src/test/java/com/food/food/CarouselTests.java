package com.food.food;


import com.food.model.Carousel;
import com.food.service.ICarouselService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
@Log4j2
public class CarouselTests {


    @Autowired
    ICarouselService service;



    @Test
    void updateCategory() {


    }

    @Test
    @Transactional
    void deleteCategory() {




    }

    @Test
    void addCategory() {
        Carousel carousel =new Carousel();
        carousel.setImg("123");
        carousel.setLink("4566");
        carousel.setMerchant_id(1);
        Carousel carousel1 = service.addCarousel(carousel);
        System.out.println(carousel);


    }



    @Test
    void addAllCategoryWithAMerchant() {



    }
}
