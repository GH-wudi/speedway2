package com.example.speedway.controller;

import com.example.speedway.common.Result;
import com.example.speedway.dto.GeoJsonFeatureCollection;
import com.example.speedway.service.StationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "*") // 允许前端跨域调用
public class StationController {

    private final StationService stationService;

    @GetMapping("/points")
    public Result<GeoJsonFeatureCollection> getSpatialData() {
        GeoJsonFeatureCollection data = stationService.getAllStationsAsGeoJson();
        return Result.success(data);
    }
}
