package com.food.model.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * status:  OPENING
 *          CLOSED
 */
@Data
public class ProductVO {
    private Integer id;

    private Date create_date;

    private String description;

    private String hot;

    private String name;

    private BigDecimal price;

    private BigDecimal priceprev1;

    private BigDecimal priceprev2;

    private Integer quantity_remaining;

    private Integer sales_volume;

    private String status;

    private Date update_date;

    private Integer merchant_id;
    private List<ImgVO> imgs;
    private List<Integer> categoryIds;


}
