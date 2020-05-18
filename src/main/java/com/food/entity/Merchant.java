package com.food.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;
    @Column
    private String notice;


    @Enumerated(EnumType.STRING)
    private Status status;

    public enum Status{
        OPENING,
        CLOSED
    }




}
