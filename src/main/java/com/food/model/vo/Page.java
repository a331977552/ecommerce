package com.food.model.vo;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.Collections;
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
        page.setOffset(page.getPageSize()*page.getCurrentPage());
        return page;
    }

    public static <VO> Page <VO> buildResult(Page<VO> source, int totalElements, List<VO> items){
        Page<VO> target=new Page<>();
        BeanUtils.copyProperties(source,target);
        target.setTotalElements(totalElements);
        target.setTotalPages(((totalElements+target.getPageSize()-1)/target.getPageSize()));
        target.setCurrentPage(target.getCurrentPage()<= 0 ?0:target.getCurrentPage()>=target.getTotalPages()? target.getTotalPages()-1:target.getCurrentPage());
        target.setFirst(target.getCurrentPage() == 0);
        target.setLast( target.getCurrentPage()+1 == target.getTotalPages());
        target.setEmpty(items.size() == 0);
        target.setItems(items);
        return target;
    }
    public static <VO> Page <VO> emptyPage(){
        Page<VO> target=new Page<>();
        target.setItems(Collections.emptyList());
        target.setTotalElements(0);
        target.setTotalPages(0);
        target.setCurrentPage(0);
        target.setOffset(0);
        target.setFirst(true);
        target.setLast(true);
        return target;
    }




}
