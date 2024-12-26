package com.ravs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ravs.entities.Vehicle;
import com.ravs.repo.VehicleRepo;

@RestController
@RequestMapping("/user")
public class UserAPIControler {
    @Autowired
    private VehicleRepo vehicleRepo;
    
    @GetMapping("/get-vehicles")
    public List<Vehicle> getVehicles(@RequestParam("userId") int userId){
        System.out.println("public api called **************************> " + userId);
        return vehicleRepo.getVehicleByUserId(userId);
    }
}
