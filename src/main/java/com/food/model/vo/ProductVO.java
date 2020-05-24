package com.food.entity.vo;

import com.food.entity.Img;
import com.food.entity.Merchant;
import com.food.entity.Product;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class ProductVO {
    private Integer id;
    private String name;
    private BigDecimal priceprev1;
    private BigDecimal priceprev2;
    private BigDecimal price;
    private String hot;
    private Merchant merchant;
    private String description;
    private List<Img> imgs;
    private Product.Status status;
    private Integer quantityRemaining;
    private Integer salesVolume;
    public enum Status{
        ON_SALE,
        OUT_OF_ORDER
    }
    private Date createDate;
    private Date updateDate;
    private List<Integer> categoryIds;
}
