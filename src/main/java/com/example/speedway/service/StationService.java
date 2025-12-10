package com.example.speedway.service;

import com.example.speedway.dto.GeoJsonFeature;
import com.example.speedway.dto.GeoJsonFeatureCollection;
import com.example.speedway.dto.GeoJsonGeometry;
import com.example.speedway.entity.ChargingStation;
import com.example.speedway.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public GeoJsonFeatureCollection getAllStationsAsGeoJson() {
        // 1. 从数据库获取原始数据
        List<ChargingStation> stations = stationRepository.findAll();

        // 2. 转换为 GeoJSON Feature 列表
        List<GeoJsonFeature> features = stations.stream().map(station -> {

            // 构建几何点 (注意：GeoJSON 坐标顺序通常是 [经度, 纬度])
            GeoJsonGeometry geometry = GeoJsonGeometry.builder()
                    .coordinates(new Double[]{station.getLon(), station.getLat()})
                    .build();

            // 构建属性 (Name, Address, etc.)
            Map<String, Object> properties = new HashMap<>();
            properties.put("id", station.getId());
            properties.put("name", station.getName());
            properties.put("address", station.getAddress());
            properties.put("pname", station.getPname());
            properties.put("cityname", station.getCityname());

            // 构建 Feature
            return GeoJsonFeature.builder()
                    .geometry(geometry)
                    .properties(properties)
                    .build();

        }).collect(Collectors.toList());

        // 3. 封装为 FeatureCollection
        return GeoJsonFeatureCollection.builder()
                .features(features)
                .build();
    }
}