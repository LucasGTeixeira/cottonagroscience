package com.lucasgteixeira.cottonagroscience.service;

import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HarvestService {

    private final HarvestRepository harvestRepository;

    @Autowired
    public HarvestService(HarvestRepository harvestRepository) {
        this.harvestRepository = harvestRepository;
    }

    public List<Harvest> getHarvests(){
        return harvestRepository.findAll();
    }

    public void addNewHarvest(Harvest harvest){
        Optional<Harvest> harvestOptional = harvestRepository.findById(harvest.getId());
        if(harvestOptional.isPresent())
            throw new IllegalStateException("harvest already registered");
        else{
            harvestRepository.save(harvest);
        }
    }

    public Harvest getHarvestById(Long id){
        return harvestRepository.findHarvestById(id);
    }

    public void updateHarvest(Harvest harvest){
        harvestRepository.save(harvest);
    }

    public void deleteHarvest(Long id){
        harvestRepository.deleteHarvestById(id);
    }
}
