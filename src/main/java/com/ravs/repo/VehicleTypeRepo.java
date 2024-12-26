package com.ravs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ravs.entities.VehicleType;

public interface VehicleTypeRepo extends JpaRepository<VehicleType, Long> {
    
}
