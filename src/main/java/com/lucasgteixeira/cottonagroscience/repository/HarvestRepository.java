package com.lucasgteixeira.cottonagroscience.repository;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.model.Harvest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface HarvestRepository extends JpaRepository<Harvest, Long> {

    @Transactional(readOnly = false)
    void deleteHarvestById(Long id);

    @Transactional(readOnly = true)
    Harvest findHarvestById(Long id);

    @Transactional(readOnly = true)
    Harvest findHarvestByName(String name);
    @Transactional(readOnly = true)
    Harvest findHarvestByProfitMargin(BigDecimal margin);
}
