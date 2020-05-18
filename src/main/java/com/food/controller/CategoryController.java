package com.food.controller;

import com.food.entity.vo.CategoryVO;
import com.food.exception.NoSuchEntityException;
import com.food.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/cate")
public class CategoryController {


    @Autowired
   CategoryService service;

//    public CategoryController(CategoryService service) {
//        this.service = service;
//    }
    @PostMapping("/add")
    public ResponseEntity<CategoryVO> addCategory(@Valid @RequestBody CategoryVO Category){

        return ResponseEntity.ok(service.addCategory(Category));
    }
    @PostMapping("/update")
    public ResponseEntity<CategoryVO> updateCategory(@Valid @RequestBody CategoryVO Category){
        service.updateCategory(Category);
        return  ResponseEntity.ok().build();
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<CategoryVO> deleteCategory(@PathVariable("id") Integer id){

        service.deleteCategoryById(id);

        return  ResponseEntity.ok().build();
    }
    @PostMapping("/get/{id}")
    public ResponseEntity<CategoryVO> getCategory(@PathVariable("id") Integer id){

        return ResponseEntity.ok(service.getCategoryById(id).orElseThrow(()->new NoSuchEntityException("common.null.exist","Category "+id)));
    }
    @PostMapping("/findAll")
    public ResponseEntity<List<CategoryVO>> getAllCategory(){
        return ResponseEntity.ok(service.getAll());
    }
    @PostMapping("/findAllwithAllProducts")
    public ResponseEntity<List<CategoryVO>> findAllwithAllProducts(){
        return ResponseEntity.ok(service.getAllWithAllProducts());
    }
    @PostMapping("/findByExample")
    public ResponseEntity<List<CategoryVO>> getAllCategory(@RequestBody CategoryVO category){
        return ResponseEntity.ok(service.getAll(category));
    }


}
