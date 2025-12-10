package com.example.speedway.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Map;

// 2. 单个要素 (Feature)
@Data
@Builder
public class GeoJsonFeature {
    @Builder.Default
    private String type = "Feature";
    private GeoJsonGeometry geometry;
    private Map<String, Object> properties;
}