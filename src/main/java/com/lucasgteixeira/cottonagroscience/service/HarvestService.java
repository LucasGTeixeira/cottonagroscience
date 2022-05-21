package com.lucasgteixeira.cottonagroscience.service;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class HarvestService {

    private final HarvestRepository harvestRepository;

    @Autowired
    public HarvestService(HarvestRepository harvestRepository) {
        this.harvestRepository = harvestRepository;
    }

    @Transactional
    public void addNewHarvest(Harvest harvest){
        Optional<Harvest> harvestOptional = harvestRepository.findById(harvest.getId());
        if(harvestOptional.isPresent())
            throw new IllegalStateException("harvest already registered");
        else{
            harvestRepository.save(harvest);
        }
    }

    public List<Harvest> getHarvests(){
        return harvestRepository.findAll();
    }

    public Harvest getHarvestById(Long id){
        return harvestRepository.findHarvestById(id);
    }

    @Transactional
    public void updateHarvest(Harvest harvest){
        harvestRepository.save(harvest);
    }

    @Transactional
    public void deleteHarvest(Long id){
        harvestRepository.deleteHarvestById(id);
    }

    public Harvest getHarvestByName(String name){
        return harvestRepository.findHarvestByName(name);
    }

    public Harvest getHarvestByProfitMargin(BigDecimal margin){
        return harvestRepository.findHarvestByProfitMargin(margin);
    }
}
