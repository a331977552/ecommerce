package com.food.controller;


import com.food.model.vo.MerchantVO;
import com.food.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/auth/manage")
public class ManagementController {





    @Autowired
    IMerchantService service;

    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<MerchantVO> addProduct() throws IOException {
        System.out.println("login");
        MerchantVO vo = new MerchantVO();
        vo.setRole("123");
        return ResponseEntity.ok(vo);
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/merchantManagement")
    public ResponseEntity<MerchantVO> manageMerchant() throws IOException {
        System.out.println("manageMerchant");
        MerchantVO vo = new MerchantVO();
        vo.setRole("123");
        return ResponseEntity.ok(vo);
    }



}
