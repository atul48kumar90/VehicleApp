package com.example.vehicle.controller;


import com.example.vehicle.entity.Pictures;
import com.example.vehicle.entity.Vehicle;
import com.example.vehicle.repository.PictureRepo;
import com.example.vehicle.repository.VehicleRepo;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class VehicleController {

    @Autowired
    private VehicleRepo vehicleRepo;

    @Autowired
    private PictureRepo pictureRepo;




    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

    @PostMapping("/{vehicleId}/pictures")
    public Pictures addPictureToVehicle(@PathVariable String vehicleId, @RequestBody Pictures picture) {
        Vehicle vehicle = vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
        picture.setVehicle(vehicle);
        return pictureRepo.save(picture);
    }

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicleWithPictures(@PathVariable String vehicleId) {
        return vehicleRepo.findById(vehicleId)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found"));
    }

    @PutMapping("/update")
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepo.save(vehicle);
    }

}
