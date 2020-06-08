package com.food.controller;

import com.food.model.vo.MerchantVO;
import com.food.service.IMerchantService;
import com.food.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/merchant")
public class MerchantController {


    @Autowired
    IMerchantService service;

    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping()
    public ResponseEntity<MerchantVO> findByToken(HttpServletRequest request) throws IOException {
        String token = request.getHeader(JWTUtil.TOKEN_HEADER).replace(JWTUtil.TOKEN_PREFIX, "");
        String username = JWTUtil.getUsername(token);
        String role = JWTUtil.getUserRole(token);
        MerchantVO byUsername = service.findByUsername(username);
        return ResponseEntity.ok(byUsername);
    }

}
