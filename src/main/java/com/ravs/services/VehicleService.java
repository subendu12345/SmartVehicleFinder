package com.ravs.services;

import java.util.List;

import com.ravs.DTO.VehicleOwnerDTO;
import com.ravs.entities.Vehicle;

public interface VehicleService {
    Vehicle creatVehicle(Vehicle vehicle);
    List<VehicleOwnerDTO> getVehicleList(String pincode);
    List<Vehicle> getVehicleList(int id);
    Vehicle updateVehicle(Vehicle vehicle);
    boolean deleteVehicle(Long id);    
}