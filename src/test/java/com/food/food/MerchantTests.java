package com.food.food;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.entity.Img;
import com.food.entity.Product;
import com.food.entity.vo.CategoryVO;
import com.food.entity.vo.ProductVO;
import com.food.service.CategoryService;
import com.food.service.ProductService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootTest()
public class MerchantTests {



    @Autowired
    CategoryService categoryService;

    static {

    }

    @Autowired
    ProductService service;

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

        Page<ProductVO> categoryById = service.getAll(PageRequest.of(0,10));
        ObjectMapper mapper=new ObjectMapper();
        String s = mapper.writeValueAsString(categoryById);

        System.out.println(s);

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
                product.setQuantityRemaining(random.nextInt(999));
                product.setPrice(new BigDecimal(random.nextInt(150)));
                product.setSalesVolume(random.nextInt(999));
                product.setName(names[nameIndex]+ index);
                product.setStatus(Product.Status.ON_SALE);
                Img img = new Img();
                img.setUrl("https://i.picsum.photos/id/"+index+"/300/200.jpg");
                product.setImgs(Arrays.asList(img));
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
