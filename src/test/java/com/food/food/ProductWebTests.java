package com.food.food;

import com.food.service.ICategoryService;
import com.food.service.IProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest()

@AutoConfigureMockMvc
public class ProductWebTests {


    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ICategoryService categoryService;

    static {

    }

    @Autowired
    IProductService service;

    @BeforeAll
    static void beforeTest() {

    }
    @Test
    public void getAllProducts() throws Exception {
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/product/findAll")).andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
        MvcResult mvcResult = resultActions.andReturn();
        String asyncResult =mvcResult.getResponse().getContentAsString();
        System.out.println(asyncResult);
//        System.out.println(mvcResult);
    }
}
