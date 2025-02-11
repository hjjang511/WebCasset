package com.project.webbackend.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Event-driven approach with Spring Data JPA
public class Product extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 350)
    private String name;

    private int price;

    private int otpName;
     
    @OneToOne
    @JoinColumn(name = "maubang_id")
    private MauBang mauBang;

    private String matA;

    private String matB;

}
/*
SELECT products.* FROM products LEFT JOIN product_images ON products.id = product_images.product_id WHERE product_images.product_id IS NULL AND category_id=4 LIMIT 10;
select * from products where category_id=4;
* */