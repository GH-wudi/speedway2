package com.example.speedway.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

// 1. 最外层的 GeoJSON 对象
@Data
@Builder
public class GeoJsonFeatureCollection {
    @Builder.Default
    private String type = "FeatureCollection";
    private List<GeoJsonFeature> features;
}