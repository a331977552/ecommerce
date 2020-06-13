package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Page<VO> {
    private int offset;
    private int totalPages;
    private int totalElements;
    private int currentPage;
    private int pageSize;
    private String by;
    private boolean isEmpty;
    private boolean first;
    private boolean last;
    private String orderBy;
    private List<VO> items;


    public static <VO> Page<VO> of(Integer currentPage, Integer pageSize,String orderBy,String by){
        Page<VO> page = new Page<VO>();
        page.setPageSize(pageSize);
        page.setCurrentPage(currentPage);
        page.setOrderBy(orderBy);
        page.setBy(by);
        return page;
    }




}
