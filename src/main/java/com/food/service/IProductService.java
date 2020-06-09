package com.food.service;

        import com.food.model.vo.ProductNameVM;
        import com.food.model.vo.ProductVO;

        import java.util.List;

public interface IProductService {

    ProductVO addProduct(ProductVO product);
    void updateProductSelective(ProductVO product);
    void updateAllProducts(Iterable<ProductVO> products);
    void updateProduct(ProductVO product);
    void deleteProductById(Integer id);
    ProductVO getProductById(Integer id);
    long count(ProductVO example);
    List<ProductVO> getProductByIds(List<Integer> ids);
    List<ProductVO> getProductsByCategoryId(Integer id);

    long countProductsByCategoryId(Integer id);
    List<ProductVO> getAll();
    com.food.model.vo.Page<ProductVO> getAll(ProductVO example,com.food.model.vo.Page<ProductVO> page);
    List<ProductVO> getAll(ProductVO product);


    List<ProductNameVM> getAllProductNames();
}
