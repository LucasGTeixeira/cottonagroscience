package com.lucasgteixeira.cottonagroscience.repository;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface FarmerRepository extends JpaRepository<Farmer, Long> {
    Optional<Farmer> findFarmerByEmail(String email);

    void deleteFarmerById(Long id);

    Farmer findFarmerById (Long id);

    Optional<Farmer> findFarmerByEmailAndPassword(String email, String password);

    Farmer findFarmerByName(String name);
}
