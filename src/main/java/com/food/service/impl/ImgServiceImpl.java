package com.food.service.impl;

import com.food.entity.Img;
import com.food.repository.ImgRepository;
import com.food.service.ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImgServiceImpl implements ImgService {

    @Autowired
    ImgRepository repository;
    @Override
    public Img addImg(Img img) {

        return repository.save(img);
    }

    @Override
    public Img findImgById(Integer imgId) {

        return repository.findById(imgId).orElseThrow();
    }
}
