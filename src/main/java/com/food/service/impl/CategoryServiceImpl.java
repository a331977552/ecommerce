package com.food.service.impl;

import com.food.exception.UnexpectedException;
import com.food.mappers.CategoryMapper;
import com.food.mappers.CategoryProductMapper;
import com.food.model.Category;
import com.food.model.CategoryExample;
import com.food.model.CategoryProductExample;
import com.food.model.vo.CategoryVO;
import com.food.model.vo.MerchantVO;
import com.food.service.ICategoryService;
import com.food.service.IMerchantService;
import com.food.service.IProductService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class CategoryServiceImpl implements ICategoryService {


    private final CategoryMapper mapper;
    private final CategoryProductMapper categoryProductMapper;
    private IMerchantService merchantService;
    @Autowired
    private IProductService productService;

    public CategoryServiceImpl(CategoryMapper mapper, CategoryProductMapper categoryProductMapper, IMerchantService merchantService) {

        this.mapper = mapper;

        this.categoryProductMapper = categoryProductMapper;
        this.merchantService = merchantService;
    }


    CategoryVO convertToVO(Category category){
        CategoryVO categoryVO=new CategoryVO();
        BeanUtils.copyProperties(category,categoryVO);
        return categoryVO;
    }

    List<CategoryVO> convertToVOs(List<Category> categories){
        return categories.stream().map(this::convertToVO).collect(Collectors.toList());
    }



    Category convertToDAO(CategoryVO vo){
        Category category=new Category();
        BeanUtils.copyProperties(vo,category,"products","merchant");
        return category;
    }

    @Override
    public CategoryVO addCategory(CategoryVO vo) {
        vo.setId(null);
        Integer merchant_id = vo.getMerchant_id();
        MerchantVO merchant = merchantService.findMerchantById(merchant_id);
        Optional.ofNullable(merchant).orElseThrow(()->new UnexpectedException("merchant with id "+ merchant +" doesn't exist"));
        Category category = convertToDAO(vo);
        mapper.insert(category);
        vo.setId(category.getId());
        return vo;
    }

    @Override
    public void updateCategorySelective(CategoryVO CategoryVO) {

    }

    @Override
    public void updateAllCategories(Iterable<CategoryVO> Categories) {

    }

    @Override
    public void updateCategory(CategoryVO vo) {
        Category category = convertToDAO(vo);
        int res = mapper.updateByPrimaryKey(category);
        if(res == 0)
            throw  new UnexpectedException("更新失败, category: " + category);

    }

    //todo 检查是否有孩子和 parent
    @Override
    public void deleteCategoryById(Integer id) {
        CategoryProductExample example = new CategoryProductExample();
        example.createCriteria().andCategory_idEqualTo(id);
        long count = categoryProductMapper.countByExample(example);
        if(count > 0)
            throw  new UnexpectedException("删除失败, 该目录下还有 商品存在!");
        int res = mapper.deleteByPrimaryKey(id);
        if(res == 0)
            throw  new UnexpectedException("删除失败, category id: " + id +" 不存在");
    }

    @Override
    public CategoryVO getCategoryById(Integer id) {
        Category one = mapper.selectByPrimaryKey(id);
        MerchantVO merchant = merchantService.findMerchantById(one.getMerchant_id());
        CategoryVO categoryVO = convertToVO(Optional.ofNullable(one).orElseThrow(() -> new UnexpectedException("category with id " + id + " doesn't exist")));
        categoryVO.setMerchant(merchant);
        return categoryVO;
    }

    //TODO
    @Override
    public long count(CategoryVO vo) {
        CategoryExample example=new CategoryExample();
        return mapper.countByExample(example);
    }

    @Override
    public List<CategoryVO> getCategoryByIds(List<Integer> ids) {
        return  ids.stream().map(this::getCategoryById).collect(Collectors.toList());
    }

    @Override
    public List<CategoryVO> getAll() {
        List<Category> categories = mapper.selectByExample(new CategoryExample());

        return convertToVOs(categories);
    }

    //TODO
    @Override
    public List<CategoryVO> getAll(CategoryVO example) {
        List<Category> categories = mapper.selectByExample(new CategoryExample());
        return convertToVOs(categories);
    }

    @Override
    public List<CategoryVO> getAllByMerchantId(Integer merchantId) {
        Optional.ofNullable(merchantId).orElseThrow(()->new UnexpectedException("null merchant!"));
        MerchantVO merchant = merchantService.findMerchantById(merchantId);
        Optional.ofNullable(merchant).orElseThrow(()->new UnexpectedException("merchant with id "+ merchantId +" doesn't exist"));
        CategoryExample example=new CategoryExample();
        example.createCriteria().andMerchant_idEqualTo(merchantId);
        List<Category> categories = mapper.selectByExample(example);
        return convertToVOs(categories);
    }


}
