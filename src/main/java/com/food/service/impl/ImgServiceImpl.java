package com.food.service.impl;

import com.food.mappers.ImgMapper;
import com.food.model.Img;
import com.food.model.ImgExample;
import com.food.model.vo.ImgVO;
import com.food.service.IImgService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImgServiceImpl implements IImgService {

    private ImgMapper mapper;
    private ProductImgsMapper productImgsMapper;

    public ImgServiceImpl(ImgMapper mapper, ProductImgsMapper productImgsMapper) {
        this.mapper = mapper;
        this.productImgsMapper = productImgsMapper;
    }

    Img convertToDAO(ImgVO vo){
        Img img=new Img();
        BeanUtils.copyProperties(vo,img);
        return img;
    }
    ImgVO convertToVO(Img img){
        ImgVO vo=new ImgVO();
        BeanUtils.copyProperties(img,vo);
        return vo;
    }
    @Override
    public ImgVO addImg(ImgVO imgvo) {
        Img img = convertToDAO(imgvo);
        mapper.insert(img);
        imgvo.setId(img.getId());
        return imgvo;
    }

    @Override
    public ImgVO findImgById(Integer imgId) {
        return convertToVO(mapper.selectByPrimaryKey(imgId));
    }

    @Override
    public List<ImgVO> findImgsByProductId(Integer productId) {
        ProductImgsExample productImgs=new ProductImgsExample();
        productImgs.createCriteria().andProduct_idEqualTo(productId);
        List<ProductImgs> productImgs1 = productImgsMapper.selectByExample(productImgs);
        List<Integer> ids = productImgs1.stream().map(ProductImgs::getImgs_id).collect(Collectors.toList());
        ImgExample example=new ImgExample();
        example.createCriteria().andIdIn(ids);
        List<Img> imgs = mapper.selectByExample(example);
        List<ImgVO> collect = imgs.stream().map(this::convertToVO).collect(Collectors.toList());
        return collect;
    }
}
