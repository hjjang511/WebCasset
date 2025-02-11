package com.project.webbackend.Response.maubang;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.webbackend.Entity.MauBang;
import com.project.webbackend.Entity.MauBangImage;
import com.project.webbackend.Response.BaseResponse;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MauBangResponse extends BaseResponse {
  private Long id;
  private String name;
  private String thumbnail;
  // Thêm trường totalPages
  private int totalPages;

  @JsonProperty("maubang_image")
  private MauBangImage mauBangImage;


  public static MauBangResponse fromProduct(MauBang product) {
      MauBangResponse productResponse = MauBangResponse.builder()
              .id(product.getId())
              .name(product.getName())
              .thumbnail(product.getThumbnail())
              .mauBangImage(product.getImg())
              .build();
      productResponse.setCreatedAt(product.getCreatedAt());
      productResponse.setUpdatedAt(product.getUpdatedAt());
      return productResponse;
  }
}
