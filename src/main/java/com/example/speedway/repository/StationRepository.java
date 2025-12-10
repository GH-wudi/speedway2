package com.example.speedway.repository;


import com.example.speedway.entity.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<ChargingStation, Long> {
}