package com.food.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * status:  OPENING
 *          CLOSED
 */
@Data
@ToString
public class ProductVO {
    private Integer id;


    private String description;

    private String hot;

    private String name;

    private BigDecimal price;

    private BigDecimal priceprev1;

    private BigDecimal priceprev2;

    private Integer quantity_remaining;

    private Integer sales_volume;
    /**
     * IN_STOCK
     * OUT_OF_STOCK
     */
    private String status;


    private Integer merchant_id;
    private List<ImgVO> imgs;
    private List<Integer> categoryIds;

    private List<InnerCategoryVO> categories;
    private Integer weight;

    private Integer priority;

    private Integer discount;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date create_date;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm")
    private Date update_date;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class InnerCategoryVO{
        private int id;
        private String title;

    }

}
