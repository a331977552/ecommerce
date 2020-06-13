package com.food.controller;


import com.food.model.vo.CategoryVO;
import com.food.service.ICategoryService;
import com.food.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ShopController {

    @Autowired
    ICategoryService categoryService;



    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping("/shop/home")
    public ResponseEntity homeView(HttpServletRequest request) {
        String token = request.getHeader(JWTUtil.TOKEN_HEADER).replace(JWTUtil.TOKEN_PREFIX, "");
        Integer id = JWTUtil.getID(token);
        return ResponseEntity.ok("haha");
    }

    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping({"/shop/categoryEdit","/shop/categoryList"})
    public ResponseEntity<List<CategoryVO>> categoryEdit(HttpServletRequest request) {
        String token = request.getHeader(JWTUtil.TOKEN_HEADER).replace(JWTUtil.TOKEN_PREFIX, "");
        Integer id = JWTUtil.getID(token);
        List<CategoryVO> allByMerchantId = categoryService.getAllByMerchantId(id);
        return ResponseEntity.ok(allByMerchantId);
    }


}
