package com.food.food;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.model.Merchant;
import com.food.model.vo.CategoryVO;
import com.food.model.vo.ProductVO;
import com.food.service.ICategoryService;
import com.food.service.IProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootTest()
public class ProductTests {



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
    public void getAllProductsByCateId() throws Exception {
        List<ProductVO> categoryById = service.getProductsByCategoryId(1);
        System.out.println(categoryById);

    }
    @Test
    public void getAllProducts() throws Exception {
        ProductVO vo=new ProductVO();
        vo.setMerchant_id(1);
        vo.setName("邵");
        com.food.model.vo.Page<ProductVO> categoryById = service.getAll(vo,com.food.model.vo.Page.of(1,5,"price","desc"));
        com.food.model.vo.Page<ProductVO> categoryById2 = service.getAll(vo,com.food.model.vo.Page.of(2,5,"price","desc"));
        com.food.model.vo.Page<ProductVO> categoryById3 = service.getAll(vo,com.food.model.vo.Page.of(-1,5,"price","desc"));
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(categoryById);
        String s2 = mapper.writeValueAsString(categoryById2);
        String s3 = mapper.writeValueAsString(categoryById3);

        System.out.println(s);
        System.out.println(s2);
        System.out.println(s3);

    }
    @Test
    void deleteAllProduct(){
        List<ProductVO> all = service.getAll();
        for (ProductVO o : all) {
            service.deleteProductById(o.getId());
        }
    }



    @Test
    void addProduct() {
        String[] str =new String[]{        "","国际烹饪大师黄启云先生倾心打造,花雕浸醉,匀指美味", "小龙虾醉美味","一锅邵三鲜,地道绍兴菜","大名鼎鼎绍兴标签","湖南卫视天天向上,特别推荐"};
        String[] names =new String[]{"黄酒布丁","花雕醉龙虾大份", "花雕醉龙虾 (小分)","邵三鲜", "油炸臭豆腐","酒酿酸奶"};
        Random random = new Random();
        List<CategoryVO> categorys = categoryService.getAll();
        int index=0;
        for (CategoryVO category : categorys) {
            int i1 = random.nextInt(10);
            for (int i = 0; i <i1; i++) {
                ProductVO product=new ProductVO();
                int nameIndex = random.nextInt(str.length);
                product.setDescription(str[nameIndex]+ index);
                product.setQuantity_remaining(random.nextInt(999));
                product.setPrice(new BigDecimal(random.nextInt(150)));
                product.setSales_volume(random.nextInt(999));
                Merchant merchant=new Merchant();
//                merchant.setId(category);
////
//                product.setName(names[nameIndex]+ index);
//                product.setm(merchant);
//                product.setStatus(Product.Status.ON_SALE);
//                Img img = new Img();
//                img.setUrl("https://i.picsum.photos/id/"+index+"/300/200.jpg");
//                product.setImgs(Arrays.asList(img));
                List<Integer> lists=new ArrayList<>();
                lists.add(category.getId());
                int i2 = random.nextInt(2);
                for (int j = 0; j < i2; j++) {
                    int i3 = random.nextInt(categorys.size());
                    CategoryVO cate = categorys.get(i3);
                    if(!lists.contains(cate.getId())){
                        lists.add(cate.getId());
                    }
                }
                product.setCategoryIds(lists);
                service.addProduct(product);
                index++;
            }
        }




    }
}
