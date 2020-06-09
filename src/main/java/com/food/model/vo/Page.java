package com.food.model.vo;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Page<VO> {
    private boolean isEmpty;
    private boolean last;
    private boolean first;
    private int totalPages;
    private int totalElements;
    private int currentPage;
    private int pageSize;
    private String orderBy;
    private List<VO> items;


    public static <VO> Page<VO> of(int pageNumber, int pageSize,String orderBy){
        Page<VO> page = new Page<VO>();
        page.setPageSize(pageSize);
        page.setCurrentPage(pageNumber);
        page.setOrderBy(orderBy);
        return page;
    }




}
