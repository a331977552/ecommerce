package com.food.service;


import com.food.model.Carousel;

import java.util.List;
import java.util.Optional;

public interface ICarouselService {

    Carousel addCarousel(Carousel Carousel);
    void updateCarouselSelective(Carousel Carousel);
    void updateAllCarousels(Iterable<Carousel> Carousels);
    void updateCarousel(Carousel Carousel);
    void deleteCarouselById(Integer id);
    Optional<Carousel> getCarouselById(Integer id);
    long count(Carousel example);
    List<Carousel> getCarouselByIds(List<Integer> ids);
    List<Carousel> getAllCarousel();


}
