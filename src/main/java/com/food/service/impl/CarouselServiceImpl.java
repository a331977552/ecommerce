package com.food.service.impl;

import com.food.mappers.CarouselMapper;
import com.food.model.Carousel;
import com.food.service.ICarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarouselServiceImpl implements ICarouselService {

@Autowired
    CarouselMapper mapper;
    @Override
    public Carousel addCarousel(Carousel carousel) {
         mapper.insert(carousel);
        return carousel;
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
