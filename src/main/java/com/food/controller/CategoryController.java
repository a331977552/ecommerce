package com.food.controller;

import com.food.model.vo.CategoryVO;
import com.food.service.ICategoryService;
import com.food.service.IProductService;
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
    ICategoryService service;

    @Autowired
    IProductService productService;

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
