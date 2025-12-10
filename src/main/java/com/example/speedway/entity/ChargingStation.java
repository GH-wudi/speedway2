package com.example.speedway.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "charging_station")
public class ChargingStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 对应截图中的 lon
    private Double lon;

    // 对应截图中的 lat
    private Double lat;

    private String name;

    private String address;

    private String pname;

    private String cityname;
}
