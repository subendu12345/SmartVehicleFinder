package com.ravs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ravs.DTO.VehicleOwnerDTO;
import com.ravs.entities.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Long> {

    @Query("SELECT v FROM Vehicle v WHERE v.pincode = :pincode")
    public List<Vehicle> getVehicleByPincode(@Param("pincode") String pincode);

    @Query("SELECT new com.ravs.DTO.VehicleOwnerDTO(v, u.name, u.phone) FROM Vehicle v, User u WHERE v.created_by_id = u.id AND u.pincode LIKE %:pincode%")
    public List<VehicleOwnerDTO> getVehicleByPincodeLike(@Param("pincode") String pincode);

    @Query("SELECT v FROM Vehicle v WHERE v.created_by_id = :userId")
    public List<Vehicle> getVehicleByUserId(@Param("userId") int userId);

    @Query("SELECT new com.ravs.DTO.VehicleOwnerDTO(v, u.name, u.phone) FROM Vehicle v, User u WHERE v.created_by_id = u.id ORDER BY v.id DESC LIMIT 6") 
    public List<VehicleOwnerDTO> getLatestVehicles();
    
}
