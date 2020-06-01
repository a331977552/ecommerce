package com.food.utils;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString

public class ErrorDetails {

    private long timestamp;
    private String title;
    private String detail;
    private int status;
    private String path;

    public ErrorDetails() {
    }

    public static ErrorDetails badRequest(String title, String detail, String path){
        return  new ErrorDetails(new Date(),title,detail,path,400);
    }
    public static ErrorDetails forbidden(String title, String detail, String path){
        return  new ErrorDetails(new Date(),title,detail,path,403);
    }
    public static ErrorDetails unauthorized(String title, String detail, String path){
        return  new ErrorDetails(new Date(),title,detail,path,401);
    }


    public static ErrorDetails badRequest(String title, String detail){
        return  new ErrorDetails(new Date(),title,detail,null,400);
    }
    public static ErrorDetails serverError(String title, String detail){

        return  new ErrorDetails(new Date(),title,detail,null,500);
    }

    public ErrorDetails(String title, String detail, String path,int status) {
        this.timestamp=System.currentTimeMillis();
        this.title = title;
        this.detail = detail;
        this.status = status;
        this.path=path;
    }

    public ErrorDetails(Date date, String title, String detail,  String path,int status) {
        this.timestamp=System.currentTimeMillis();
        this.title = title;
        this.detail = detail;
        this.status = status;
        this.path=path;
    }
}
