package com.food.food;

import com.food.exception.UnexpectedException;
import com.food.model.constants.MerchantConstants;
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
        vo.setStatus(MerchantConstants.OPENING);
        vo.setName("红火火 *新");
        vo.setNotice("最近有打折哦");
        vo.setAlipay_url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590824560557&di=7c91bc516e24beb74709554af03dcc78&imgtype=0&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D3381390367%2C3810581293%26fm%3D214%26gp%3D0.jpg");
        vo.setWechat_payment_code_url("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1724274295,55315530&fm=26&gp=0.jpg");
        vo.setWechat_url("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3262068686,2008117785&fm=26&gp=0.jpg");
        vo.setAlipay_payment_code_url("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2678058129,1326138290&fm=26&gp=0.jpg");
        vo.setBank_card_name("xianghua huang");
        vo.setBank_card_number("4128 2421 1242 1221");
        vo.setPhone("+44 2131231");
        service.updateMerchant(vo);
    }
    @Test
    void testAdd(){
        MerchantVO vo=new MerchantVO();

        vo.setAddress("中国城 103号 老师傅餐厅");
        vo.setStatus(MerchantConstants.OPENING);
        vo.setName("老师傅开车");
        vo.setNotice("最近有打折哦22");

        vo.setAlipay_url("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590824560557&di=7c91bc516e24beb74709554af03dcc78&imgtype=0&src=http%3A%2F%2Fimg2.imgtn.bdimg.com%2Fit%2Fu%3D3381390367%2C3810581293%26fm%3D214%26gp%3D0.jpg");
        vo.setWechat_payment_code_url("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1724274295,55315530&fm=26&gp=0.jpg");
        vo.setBank_card_name("xianghua huang");
        vo.setBank_card_number("4128 2421 1242 1221");
        vo.setAlipay_payment_code_url("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=2678058129,1326138290&fm=26&gp=0.jpg");
        vo.setPhone("+44 2131231");

        service.addMerchant(vo);
        System.out.println(vo);
    }




}
