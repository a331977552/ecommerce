package com.food.food;


import com.food.mappers.CategoryMapper;
import com.food.entity.Merchant;
import com.food.entity.vo.CategoryVO;
import com.food.model.Category;
import com.food.service.CategoryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CategoryTests {

    static List<String> titles = new ArrayList<>();

    {


    }

    @Autowired
    CategoryService service;

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
    @Autowired
    CategoryMapper mapper;
    @Test
    void deleteAllCategory() {
        Category category = mapper.selectByPrimaryKey(12);

        System.out.println(category);
    }

    @Test
    void addCategory() {

        CategoryVO category = new CategoryVO();
        category.setTitle("测试名字");
        category.setPriority(111);

        Merchant merchant = new Merchant();
        merchant.setStatus(Merchant.Status.CLOSED);
        merchant.setName("必复元");
        merchant.setId(3);
        category.setMerchant(merchant);
        service.addCategory(category);


    }



    @Test
    void contextLoads() {
        int priority=0;
        for (String title : titles) {
            CategoryVO category = new CategoryVO();
            category.setTitle(title);
            category.setPriority(priority);
            Merchant merchant = new Merchant();
            merchant.setId(1);
            category.setMerchant(merchant);
            service.addCategory(category);
            priority++;
        }



    }
}
