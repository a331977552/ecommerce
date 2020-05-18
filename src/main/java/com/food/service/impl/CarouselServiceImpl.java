package com.food.service.impl;

import com.food.entity.Carousel;
import com.food.service.CarouselService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarouselServiceImpl implements CarouselService {


    @Override
    public Carousel addCarousel(Carousel Carousel) {
        return null;
    }

    @Override
    public void updateCarouselSelective(Carousel Carousel) {

    }

    @Override
    public void updateAllCarousels(Iterable<Carousel> Carousels) {

    }

    @Override
    public void updateCarousel(Carousel Carousel) {

    }

    @Override
    public void deleteCarouselById(Integer id) {

    }

    @Override
    public Optional<Carousel> getCarouselById(Integer id) {
        return Optional.empty();
    }

    @Override
    public long count(Carousel example) {
        return 0;
    }

    @Override
    public List<Carousel> getCarouselByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<Carousel> getAllCarousel() {
        return null;
    }
}
