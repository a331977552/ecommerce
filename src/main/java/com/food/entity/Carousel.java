package com.food.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity()
@Data
@ToString
public class Carousel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String title;
    @Column
    private String link;
    @Column
    private String img;

    @ManyToOne()
    private Merchant merchant;


}
