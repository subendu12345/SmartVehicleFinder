package com.ravs.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravs.entities.Vehicle;
import com.ravs.repo.VehicleRepo;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepo vehicleRepo;


    public void saveVehicle(Vehicle vehicle) {
        vehicleRepo.save(vehicle);
        System.out.println("Vehicle saved");
    }
    
}
