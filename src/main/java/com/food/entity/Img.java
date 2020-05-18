package com.food.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity()
@Data
@ToString
public class Img {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String url;
    @Column
    private String fileName;
    @Column
    private String fullUrl;
    @Column
    private String size;

}
