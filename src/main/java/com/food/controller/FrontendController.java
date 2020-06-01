package com.food.controller;


import com.food.model.vo.CategoryVO;
import com.food.model.vo.HomeVO;
import com.food.model.vo.MerchantVO;
import com.food.service.ICategoryService;
import com.food.service.IMerchantService;
import com.food.service.IProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/ui")
public class FrontendController {


    final ICategoryService categoryService;

    final IMerchantService merchantService;

    final IProductService productService;

    public FrontendController(ICategoryService categoryService, IMerchantService merchantService, IProductService productService) {
        this.categoryService = categoryService;
        this.merchantService = merchantService;
        this.productService = productService;
    }

    @PostMapping("/merchant/{merchantId}")
    public ResponseEntity<HomeVO> homeView(@PathVariable(value = "merchantId") Integer id) {
        List<CategoryVO> all = categoryService.getAllByMerchantId(id);
        all.forEach(vo -> vo.setProducts(productService.getProductsByCategoryId(vo.getId())));
        MerchantVO merchant = merchantService.findMerchantById(id);
        HomeVO homeVO = new HomeVO();
        homeVO.setCategories(all);
        homeVO.setMerchant(merchant);
        return ResponseEntity.ok(homeVO);
    }


}
