package com.food.utils;

import com.food.exception.UnexpectedException;

public class CheckUpdateUtil {




    public static boolean test(Integer updateCount,String msg) {
        if(updateCount <= 0 )
            throw new UnexpectedException(msg);
        return true;
    }
}
