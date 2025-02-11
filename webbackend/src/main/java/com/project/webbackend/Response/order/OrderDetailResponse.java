package com.project.webbackend.Response.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.webbackend.Entity.OrderDetail;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailResponse {
  private Long id;

  @JsonProperty("order_id")
  private Long orderId;

  @JsonProperty("product_id")
  private Long productId;

  @JsonProperty("number_of_products")
  private int numberOfProducts;

  @JsonProperty("total_money")
  private Float totalMoney;

  public static OrderDetailResponse fromOrderDetail(OrderDetail orderDetail) {
    return OrderDetailResponse
        .builder()
        .id(orderDetail.getId())
        .orderId(orderDetail.getOrder().getId())
        .productId(orderDetail.getProduct().getId())
        .numberOfProducts(orderDetail.getNumberOfProducts())
        .totalMoney(orderDetail.getTotalMoney())
        .build();
  }
}
