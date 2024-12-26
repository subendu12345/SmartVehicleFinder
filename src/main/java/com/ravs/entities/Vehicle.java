// This is the Vehicle entity class which is used to map the vehicle table in the database.

package com.ravs.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "vehicle")
public class Vehicle extends BaseEntity {

    @Column(nullable = false)
    private int pincode;

    private boolean is_active;

    private String model;

    private String brand;

    private int vehicle_type_id;

    @Column(nullable = false, unique = true)
    private String vehicle_number;

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public Vehicle() {
    }

    public int getVehicle_type_id() {
        return vehicle_type_id;
    }

    public void setVehicle_type_id(int vehicle_type_id) {
        this.vehicle_type_id = vehicle_type_id;
    }

    @Override
    public String toString() {
        return "Vehicle [pincode=" + pincode + ", is_active=" + is_active + ", model=" + model + ", brand=" + brand
                + ", vehicle_type_id=" + vehicle_type_id + ", vehicle_number=" + vehicle_number + "]";
    }
 

}
