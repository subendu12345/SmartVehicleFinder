package com.ravs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravs.entities.VehicleType;
import com.ravs.repo.VehicleTypeRepo;

@Service
public class VehicleTypeService {

    @Autowired
    private VehicleTypeRepo vehicleTypeRepo;

    public void saveVehicleType(VehicleType vehicleType) {
        vehicleTypeRepo.save(vehicleType);

    }
    
}
