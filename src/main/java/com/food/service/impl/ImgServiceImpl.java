package com.food.service.impl;

import com.food.mappers.ImgMapper;
import com.food.mappers.ProductImgMapper;
import com.food.model.Img;
import com.food.model.ImgExample;
import com.food.model.ProductImg;
import com.food.model.ProductImgExample;
import com.food.model.vo.ImgVO;
import com.food.service.IImgService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImgServiceImpl implements IImgService {

    private ImgMapper mapper;
    private ProductImgMapper productImgsMapper;

    public ImgServiceImpl(ImgMapper mapper, ProductImgMapper productImgsMapper) {
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
        ProductImgExample productImgs=new ProductImgExample();
        productImgs.createCriteria().andProduct_idEqualTo(productId);
        List<ProductImg> productImgs1 = productImgsMapper.selectByExample(productImgs);
        List<Integer> ids = productImgs1.stream().map(ProductImg::getImg_id).collect(Collectors.toList());
        ImgExample example=new ImgExample();
        example.createCriteria().andIdIn(ids);
        List<Img> imgs = mapper.selectByExample(example);
        List<ImgVO> collect = imgs.stream().map(this::convertToVO).collect(Collectors.toList());
        return collect;
    }
}
