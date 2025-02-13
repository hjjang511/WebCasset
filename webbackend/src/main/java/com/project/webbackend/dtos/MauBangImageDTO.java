package com.project.webbackend.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.*;


@Data//toString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MauBangImageDTO {
    @JsonProperty("maubang_id")
    @Min(value = 1, message = "MauBang's ID must be > 0")
    private Long maubangid;

    @Size(min = 5, max = 200, message = "Image's name")
    @JsonProperty("image_url")
    private String imageUrl;
}
