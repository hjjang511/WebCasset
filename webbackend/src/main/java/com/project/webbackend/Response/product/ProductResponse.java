package com.project.webbackend.Response.product;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.webbackend.Entity.Product;
import com.project.webbackend.Response.BaseResponse;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse extends BaseResponse {
    private Long id;
    private String name;
    private int price;
    private int otpName;
    private String matA;
    private String matB;
    private long maubangId;

    // Thêm trường totalPages
    private int totalPages;

    public static ProductResponse fromProduct(Product product) {
        ProductResponse productResponse = ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .otpName(product.getOtpName())
                .matA(product.getMatA())
                .matB(product.getMatB())
                .maubangId(product.getMauBang().getId())
                .build();
        productResponse.setCreatedAt(product.getCreatedAt());
        productResponse.setUpdatedAt(product.getUpdatedAt());
        return productResponse;
    }
}
