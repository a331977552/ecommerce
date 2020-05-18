package com.food.utils;

public class Constants {

    public static final String USER_SESSION_ID = "userSessionId";
    /**
     * the user has not been created.
     * it is a temporary user still.
     */
    public static final Integer USER_EMPTY_STATE = 1;
    /**
     * user has been created.
     */
    public static final Integer USER_FILLED_STATE = 0;
    public static final Integer USER_COOKIETIME = 3600 * 24 * 365;

    public static final String USER = "user";

    public static final int CART_COOKIE_TIME = 3600 * 24 * 365;


    public static final String REDIS_NAME_PRODUCT_NAMES_PREFIX = "productNameByCategory";
}
