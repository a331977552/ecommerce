package com.food.food;


import com.food.controller.CategoryController;
import com.food.exception.UnexpectedException;
import com.food.model.constants.MerchantConstants;
import com.food.model.vo.CategoryVO;
import com.food.model.vo.MerchantVO;
import com.food.service.ICategoryService;
import com.food.service.IMerchantService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Log4j2
public class CategoryTests {

    static List<String> titles = new ArrayList<>();
    {


    }

    @Autowired
    IMerchantService merchantService;


    @Autowired
    CategoryController categoryController;


    @Autowired
    ICategoryService service;

    @BeforeAll
    static void beforeTest() {
        titles.add("招牌菜");
        titles.add("必点菜");
        titles.add("当季菜");
        titles.add("冷菜");
        titles.add("家常菜");
        titles.add("时蔬菜");
        titles.add("小吃");
        titles.add("甜品");
        titles.add("饮品");
        titles.add("酒水");
        titles.add("礼品");
    }
    @Test
    void findACategory() {
        CategoryVO category = service.getCategoryById(12);
        log.info(category);
        Assertions.assertEquals(category.getId(),12);
        try {
            CategoryVO category2= service.getCategoryById(9999);
        } catch (Exception e) {
            Assertions.assertEquals(UnexpectedException.class,e.getClass());

        }
    }
    @Test
    void findAllCategory() {
        List<CategoryVO> category = service.getAll();
        log.info(category);
    }

    @Test
    void updateCategory() {
        CategoryVO category = service.getCategoryById(13);
        category.setTitle("更新测试");
        service.updateCategory(category);
        try {
            category.setId(555);
            service.updateCategory(category);
        } catch (Exception e) {
            log.error(e);
            Assertions.assertEquals(UnexpectedException.class,e.getClass());
        }

    }

    @Test
    @Transactional
    void deleteCategory() {

        CategoryVO category = service.getCategoryById(13);
        System.out.println(category);
        try {
            service.deleteCategoryById(12);
        } catch (Exception e) {
            log.error(e);
            Assertions.assertEquals(UnexpectedException.class,e.getClass());
            UnexpectedException e1 = (UnexpectedException) e;
            Assertions.assertEquals("删除失败, 该目录下还有 商品存在!",e1.getArgs()[0]);
        }

        try {
            service.deleteCategoryById(555);
        } catch (Exception e) {
            log.error(e);
            Assertions.assertEquals(UnexpectedException.class,e.getClass());
        }

        service.deleteCategoryById(6);
        category.setTitle("id7的菜单");
        category.setId(6);
        service.addCategory(category);


    }

    @Test
    void addCategory() {

        CategoryVO category = new CategoryVO();
        category.setTitle("测试名字");
        category.setPriority(111);
        MerchantVO merchant = new MerchantVO();
        merchant.setStatus(MerchantConstants.CLOSED);
        merchant.setName("必复元");
        merchant.setId(3);
        category.setMerchant(merchant);
        CategoryVO result = service.addCategory(category);
        log.info(result);
        Assertions.assertNotNull(result.getId());

        merchant.setId(555);

        try {
            CategoryVO result2 = service.addCategory(category);
            log.info(result2);
        } catch (Exception e) {
            log.error(e);
            Assertions.assertEquals(UnexpectedException.class,e.getClass());
        }
    }



    @Test
    void addAllCategoryWithAMerchant() {
        int priority=0;
        for (String title : titles) {
            CategoryVO category = new CategoryVO();
            category.setTitle(title);
            category.setPriority(priority);
            MerchantVO merchant = new MerchantVO();
            merchant.setId(1);
            category.setMerchant(merchant);
            service.addCategory(category);
            priority++;
        }



    }
}
