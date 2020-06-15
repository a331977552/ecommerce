package com.food.utils;

public class StringUtils {


    public static boolean isEmpty(String str){
        if(null == str || str.trim().equals(""))
            return true;
        return false;
    }
}
