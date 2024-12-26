package com.ravs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravs.DTO.VehicleOwnerDTO;
import com.ravs.repo.VehicleRepo;

@RestController
@RequestMapping("/public")
public class PublicAPIControler {

    @Autowired
    private VehicleRepo vehicleRepo;    

    @GetMapping("/get-vehicles")
    public List<VehicleOwnerDTO> getVehicles(@RequestParam("pincode") String pincode){
        System.out.println("public api called **************************> " + pincode);
        return vehicleRepo.getVehicleByPincodeLike(pincode);
    }

        @GetMapping("/get-default-vehicles")
        public List<VehicleOwnerDTO> getDefaultVehicles(){
        List<VehicleOwnerDTO> vehicles = vehicleRepo.getLatestVehicles();
        System.out.println("public api called **************************> " + vehicles);
        return vehicleRepo.getLatestVehicles();
    }
    
}
