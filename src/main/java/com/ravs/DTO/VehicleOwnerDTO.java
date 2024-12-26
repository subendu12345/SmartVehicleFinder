package com.ravs.DTO;

import com.ravs.entities.Vehicle;

public class VehicleOwnerDTO {
    private Vehicle vehicle;
    private String busOwner;
    private String ownerPhone;

    public VehicleOwnerDTO(Vehicle vehicle, String busOwner, String ownerPhone) {
        this.vehicle = vehicle;
        this.busOwner = busOwner;
        this.ownerPhone = ownerPhone;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public String getBusOwner() {
        return busOwner;
    }

    public void setBusOwner(String busOwner) {
        this.busOwner = busOwner;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    

}
