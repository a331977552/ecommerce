package com.food.controller;

import com.food.model.vo.CategoryVO;
import com.food.service.ICategoryService;
import com.food.service.IProductService;
import com.food.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/api/cate")
public class CategoryController {


    @Autowired
    ICategoryService service;

    @Autowired
    IProductService productService;

//    public CategoryController(CategoryService service) {
//        this.service = service;
//    }

    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping("/add")
    public ResponseEntity<CategoryVO> addCategory(HttpServletRequest request, @RequestBody CategoryVO category){
        String token = request.getHeader(JWTUtil.TOKEN_HEADER).replace(JWTUtil.TOKEN_PREFIX, "");
        Integer id = JWTUtil.getID(token);
        category.setMerchant_id(id);
        return ResponseEntity.ok(service.addCategory(category));
    }

    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping("/update")
    public ResponseEntity<CategoryVO> updateCategory(@RequestBody CategoryVO Category){
        service.updateCategory(Category);
        return  ResponseEntity.ok().build();
    }

    @PreAuthorize("hasAnyRole('MERCHANT','ADMIN')")
    @PostMapping("/delete/{id}")
    public ResponseEntity<CategoryVO> deleteCategory(@PathVariable("id") Integer id){

        service.deleteCategoryById(id);

        return  ResponseEntity.ok().build();
    }
    @PostMapping("/get/{id}")
    public ResponseEntity<CategoryVO> getCategory(@PathVariable("id") Integer id){

        return ResponseEntity.ok(service.getCategoryById(id));
    }
    @PostMapping("/findAll")
    public ResponseEntity<List<CategoryVO>> getAllCategory(){
        List<CategoryVO> all = service.getAll();
        return ResponseEntity.ok(all);
    }

    @PostMapping("/findByExample")
    public ResponseEntity<List<CategoryVO>> getAllCategory(@RequestBody CategoryVO category){
        return ResponseEntity.ok(service.getAll(category));
    }


}
