package com.ravs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ravs.entities.VehicleType;
import com.ravs.services.VehicleTypeService;

@Controller
@RequestMapping("/admin")
public class AdminControler {

    @Autowired
    private VehicleTypeService vehicleTypeService;
    
    @RequestMapping("/vehicletype")
    public String addVehicleType(Model model){
        model.addAttribute("title", "Vehicle Type");
        model.addAttribute("vehicleType", new VehicleType());
        return "/vehicle/vehicleType";
    }

    @PostMapping("/newvehicletype")
    public String newVehicleType(@ModelAttribute("vehicleType") VehicleType vehicleType, Model model){
        System.out.println("Vehicle Type: "+ vehicleType.toString());
        vehicleTypeService.saveVehicleType(vehicleType);
        return "/vehicle/vehicleType";
    }

}
