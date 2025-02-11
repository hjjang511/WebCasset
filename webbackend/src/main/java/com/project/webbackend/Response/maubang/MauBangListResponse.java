package com.project.webbackend.Response.maubang;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class MauBangListResponse {
    private List<MauBangResponse> products;
    private int totalPages;
}
