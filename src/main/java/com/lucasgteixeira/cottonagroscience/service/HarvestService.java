package com.lucasgteixeira.cottonagroscience.service;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.repository.HarvestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class HarvestService {

    private final HarvestRepository harvestRepository;

    @Autowired
    public HarvestService(HarvestRepository harvestRepository) {
        this.harvestRepository = harvestRepository;
    }

    @Transactional
    public void addNewHarvest(Harvest harvest){
        harvestRepository.save(harvest);
    }

    @Transactional(readOnly = true)
    public List<Harvest> getHarvests(){
        return harvestRepository.findAll();
    }

    @Transactional(readOnly = true)
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

    @Transactional(readOnly = true)
    public Harvest getHarvestByName(String name){
        return harvestRepository.findHarvestByName(name);
    }

    @Transactional(readOnly = true)
    public List<Harvest> getHarvestsByProfitMargin(BigDecimal margin){
        return harvestRepository.findHarvestsByProfitMargin(margin);
    }

    @Transactional(readOnly = true)
    public Harvest getHarvestByIdAndFarmer(Long id, Farmer farmer){
        return harvestRepository.findHarvestByIdAndFarmer(id, farmer);
    }

    @Transactional(readOnly = true)
    public List<Harvest> getHarvestsByDestination(String destination){
        return harvestRepository.findHarvestsByDestination(destination);
    }
}
