package com.lucasgteixeira.cottonagroscience.service;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FarmerService {

    private final FarmerRepository farmerRepository;

    @Autowired
    public FarmerService(FarmerRepository farmerRepository) {
        this.farmerRepository = farmerRepository;
    }

    @Transactional(readOnly = true)
    public List<Farmer> getFarmers(){
        return farmerRepository.findAll();
    }

    @Transactional(readOnly = false)
    public void addNewFarmer(Farmer farmer) {
        Optional<Farmer> farmerOptional = farmerRepository.findFarmerByEmail(farmer.getEmail());
        if(farmerOptional.isPresent())
            throw new IllegalStateException("Email already in use");
        else{
            farmerRepository.save(farmer);
        }
    }

    @Transactional(readOnly = true)
    public Farmer getFarmerById(Long id){
        return farmerRepository.findFarmerById(id);
    }

    @Transactional(readOnly = false)
    public void updateFarmer(Farmer farmer){
        farmerRepository.save(farmer);
    }

    @Transactional(readOnly = false)
    public void deleteFarmer(Long id){
        farmerRepository.deleteFarmerById(id);
    }
}
