package com.food.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.food.utils.EntitySupporter;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity()
@Data
public class Product implements EntitySupporter {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    @NotNull(message = "{product.name.empty}")
    private String name;
    @Column
    private BigDecimal priceprev1;
    @Column
    private BigDecimal priceprev2;
    @Column
    @NotNull(message = "{product.price.null}")
    private BigDecimal price;
    @Column
    private String hot;
    @Column
    private String description;

    @JoinTable()
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Img> imgs;
    @Column()
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column()
    private Integer quantityRemaining;

    @ManyToOne()
    private Merchant merchant;

    @Column()
    private Integer salesVolume;

    public enum Status{
        ON_SALE,
        OUT_OF_ORDER
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @CreationTimestamp
    private Date createDate;

    @Temporal(TemporalType.TIMESTAMP)
    @org.hibernate.annotations.UpdateTimestamp
    private Date updateDate;

    @JsonBackReference
    @ManyToMany(fetch=FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name = "category_product",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false))
    private List<Category> categories;



}
