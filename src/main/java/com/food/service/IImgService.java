package com.food.service;


import com.food.model.vo.ImgVO;

import java.util.List;

public interface ImgService {

    ImgVO addImg(ImgVO img);
    ImgVO findImgById(Integer imgId);
    List<ImgVO> findImgsByProductId(Integer productId);
}
