package com.ravs.servicesImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ravs.DTO.VehicleOwnerDTO;
import com.ravs.entities.Vehicle;
import com.ravs.repo.VehicleRepo;
import com.ravs.services.VehicleService;

@Service
public class VehicleServiceImpl implements VehicleService {
    @Autowired
    private VehicleRepo vehicleRepo;

    @Override
    public Vehicle creatVehicle(Vehicle vehicle) {
       vehicleRepo.save(vehicle);
       return vehicle;
    }

    @Override
    public List<VehicleOwnerDTO> getVehicleList(String pincode) {
        return vehicleRepo.getVehicleByPincodeLike(pincode);
    }

    @Override
    public List<Vehicle> getVehicleList(int userId) {
       return vehicleRepo.getVehicleByUserId(userId); 
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateVehicle'");
    }

    @Override
    public boolean deleteVehicle(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteVehicle'");
    }
    
}
