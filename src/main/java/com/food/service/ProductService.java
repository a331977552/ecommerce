package com.food.service;

import com.food.entity.vo.ProductNameVM;
import com.food.entity.vo.ProductVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    ProductVO addProduct(ProductVO product);
    void updateProductSelective(ProductVO product);
    void updateAllProducts(Iterable<ProductVO> products);
    void updateProduct(ProductVO product);
    void deleteProductById(Integer id);
    Optional<ProductVO> getProductById(Integer id);
    long count(ProductVO example);
    List<ProductVO> getProductByIds(List<Integer> ids);
    List<ProductVO> getProductsByCategoryId(Integer id);

    long countProductsByCategoryId(Integer id);
    List<ProductVO> getAll();
    Page<ProductVO> getAll(Pageable page);
    List<ProductVO> getAll(ProductVO product);


    List<ProductNameVM> getAllProductNames();
}
