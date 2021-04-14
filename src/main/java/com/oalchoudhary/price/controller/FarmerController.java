package com.oalchoudhary.price.controller;

import com.oalchoudhary.price.model.Farmer;
import com.oalchoudhary.price.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import com.oalchoudhary.price.exception.ResourceNotFoundException;
import com.oalchoudhary.price.model.Product;
import com.oalchoudhary.price.repository.ProductRepository;
@RestController
@RequestMapping("/api")
public class FarmerController {
    @Autowired
    FarmerRepository farmerRepository;
    @GetMapping("/farmers")
    public List<Farmer> getAllFarmer(){
        return farmerRepository.findAll();
    }

    @PostMapping("/farmers")
    public Farmer createFarmer(@Valid @RequestBody Farmer farmer) { return farmerRepository.save(farmer);
    }
    @GetMapping("/farmers/{id}")
    public Farmer getFarmerByid(@PathVariable(value = "id")Long farmerId){
        return farmerRepository.findById(farmerId)
                .orElseThrow(()->new ResourceNotFoundException("Farmer","id",farmerId));
    }
    @GetMapping("/farmers/details/{phonenumber}")
    public List<Farmer> getFarmerByPhoneNumber(@PathVariable(value = "phonenumber")String phoneNumber){
        return farmerRepository.findByPhone_number(phoneNumber);
    }

    @PutMapping("farmer/{id}")
    public Farmer updateFarmer(@PathVariable (value = "id")Long farmerId,
                        @Valid @RequestBody Farmer farmerDetails){
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(()->new ResourceNotFoundException("Farmer","id",farmerId));
        farmer.setName(farmerDetails.getName());
        farmer.setState(farmerDetails.getState());
        farmer.setDistrict(farmerDetails.getDistrict());
        farmer.setPhone_number(farmerDetails.getPhone_number());
        farmer.setWhatsapp_number(farmerDetails.getWhatsapp_number());

        Farmer updatedFarmer = farmerRepository.save(farmer);
        return updatedFarmer;

    }
    @DeleteMapping
    public ResponseEntity<?> deleteFarmer(@PathVariable(value = "id")Long farmerId){
        Farmer farmer = farmerRepository.findById(farmerId)
                .orElseThrow(()->new ResourceNotFoundException("Farmer","id",farmerId));
        farmerRepository.delete(farmer);
        return ResponseEntity.ok().build();
    }
}
