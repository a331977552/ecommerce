package com.food.controller;


import com.food.model.Merchant;
import com.food.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/merchant")
public class MerchantController {



    @Autowired
    IMerchantService service;

    @PostMapping("/add")
    public ResponseEntity<Merchant> login() throws IOException {

//        return ResponseEntity.ok(addedImg);
        return null;
    }



}
