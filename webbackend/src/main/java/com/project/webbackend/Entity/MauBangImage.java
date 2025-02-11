package com.project.webbackend.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "maubangimage")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MauBangImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "maubang_id")
    private MauBang mauBang;

    @Column(name = "image_url", length = 300)
    @JsonProperty("image_url")
    private String imageUrl;

}
