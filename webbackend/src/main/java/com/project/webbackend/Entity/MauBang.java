package com.project.webbackend.Entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "maubangs")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MauBang extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    private int price;

    @Column(name = "thumbnail", length = 300)
    private String thumbnail;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "img_id")
    private MauBangImage img;
}
