// This is the controller class.

package com.ravs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ravs.repo.UserRepo;
import com.ravs.repo.VehicleTypeRepo;
import com.ravs.services.VehicleService;
import com.ravs.wrapper.VehicleWrapper;
import com.ravs.entities.User;
import com.ravs.entities.Vehicle;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired 
    private AuthController authController;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private VehicleTypeRepo vehicleTypeRepo;

    @RequestMapping("/vehicle/new")
    public String newVehicle(Model model){
        System.out.println("====> "+ authController.isAuthenticated());
        model.addAttribute("title", "new vehicle");
        model.addAttribute("vehicleWrapper", new VehicleWrapper());
        return "/vehicle/vehicleRegistration";
    }

    @RequestMapping("/vehicle/registration")
    public String vehicleRegistration(@ModelAttribute("vehicleWrapper") VehicleWrapper vehicleWrapper, Model model){
        Vehicle newVehicle = new Vehicle();
        String user_Name = authController.getAuthUserName();
        User user = userRepo.findUserByEmail(user_Name);
        newVehicle.setVehicle_type_id(3);
        newVehicle.setCreated_by_id(user.getId());
        newVehicle.setBrand(vehicleWrapper.getBrand());
        newVehicle.setModel(vehicleWrapper.getModel());
        newVehicle.setPincode(vehicleWrapper.getPincode());
        newVehicle.setVehicle_number(vehicleWrapper.getVehicle_number());
        newVehicle.setIs_active(vehicleWrapper.isIs_active());
        newVehicle.setName(vehicleWrapper.getName());
        newVehicle.setPincode(Integer.valueOf(user.getPincode()));
        System.out.println("---> "+newVehicle.toString());
        vehicleService.saveVehicle(newVehicle);

        return "/vehicle/vehicleRegistration";
       
    }

    
}
