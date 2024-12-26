package com.ravs.wrapper;

public class VehicleWrapper {
    
    private String name;
    private String model;
    private String brand;   
    private String vehicle_number;
    private int pincode;
    private boolean is_active;
    private Long user_id;
    private Long vehicle_type_id;

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
    public boolean isIs_active() {
        return is_active;
    }
    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }
    public Long getUser_id() {
        return user_id;
    }
    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
    public Long getVehicle_type_id() {
        return vehicle_type_id;
    }
    public void setVehicle_type_id(Long vehicle_type_id) {
        this.vehicle_type_id = vehicle_type_id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "VehicleWrapper [name=" + name + ", model=" + model + ", brand=" + brand + ", vehicle_number="
                + vehicle_number + ", pincode=" + pincode + ", is_active=" + is_active + ", user_id=" + user_id
                + ", vehicle_type_id=" + vehicle_type_id + "]";
    }

    
    
}
