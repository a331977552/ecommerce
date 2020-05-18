package com.food.repository;

import com.food.entity.Product;
import com.food.entity.vo.ProductNameVM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Integer>, JpaSpecificationExecutor<Product> {


    @Query(value = "SELECT new  com.food.entity.vo.ProductNameVM(u.id, u.name) FROM Product u")
    List<ProductNameVM> getAllProductNames();
    @Query("select p from Product p join Category c where c.id = :id")
    List<Product> findAllByCategoryId(Integer id);

}
