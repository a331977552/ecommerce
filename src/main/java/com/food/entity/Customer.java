package com.food.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String phone;


    @Column
    private String name;


    @Column
    private String sex;


    @Column
    private Date dateOfBirth;


    @Column
    private String wxid;

    @Column
    private String avatar;



}
