package com.food.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity()
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "{category.name.null}")
    @Column
    private String title;
    @Column
    private String description;

    @Column
    private int priority;


    @ManyToOne()
    private Merchant merchant;

    @ManyToMany(cascade = CascadeType.REFRESH,fetch = FetchType.EAGER)
    @JoinTable(name="category_product",
            joinColumns={@JoinColumn(name="category_id",referencedColumnName="id")},
            inverseJoinColumns={@JoinColumn(name="product_id",referencedColumnName="id")}
    )
    private List<Product> products=new ArrayList<>();


}
