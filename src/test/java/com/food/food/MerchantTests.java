package com.food.food;

import com.food.exception.UnexpectedException;
import com.food.model.Merchant;
import com.food.model.vo.MerchantVO;
import com.food.service.IMerchantService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;



@SpringBootTest()
public class MerchantTests {



    @Autowired
    IMerchantService service;

    @BeforeAll
    static void beforeTest() {

    }
    @Test
    void testFind(){

        MerchantVO merchantById = service.findMerchantById(2);
        assertEquals( 2,merchantById.getId());
        try {
            MerchantVO merchant = service.findMerchantById(4);
        } catch (Exception e) {
            assertEquals( UnexpectedException.class,e.getClass());
        }
    }
    @Test
    void testUpdate(){

        MerchantVO vo=new MerchantVO();
        vo.setId(1);
        vo.setAddress("中国城 102号 红火火餐厅");
        vo.setStatus(Merchant.STATUS_OPENING);
        vo.setName("红火火 *新");
        vo.setNotice("最近有打折哦");
        service.updateMerchant(vo);

    }
    @Test
    void testAdd(){
        MerchantVO vo=new MerchantVO();

        vo.setAddress("中国城 103号 老师傅餐厅");
        vo.setStatus(Merchant.STATUS_OPENING);
        vo.setName("老师傅开车");
        vo.setNotice("最近有打折哦22");

        service.addMerchant(vo);
        System.out.println(vo);
    }




}
