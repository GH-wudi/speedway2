package com.example.speedway.dto;

import lombok.Builder;
import lombok.Data;

// 3. 几何信息 (Geometry)
@Data
@Builder
public class GeoJsonGeometry {
    @Builder.Default
    private String type = "Point";
    // 数组：[经度, 纬度]
    private Double[] coordinates;
}