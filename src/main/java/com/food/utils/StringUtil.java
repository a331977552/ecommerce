package com.food.utils;


import lombok.extern.log4j.Log4j2;

import java.util.List;
@Log4j2
public class StringUtil {



    public static boolean isOneOf(String match,String ...array){
        return isOneOf(match,List.of(array));
    }
    public static boolean isOneOf(String match, List<String> array){
        if(!Lists.hasElements(array))
        {
            log.warn("empty array");
            return false;
        }
        return array.stream().anyMatch(str -> str.equals(match));
    }
}
