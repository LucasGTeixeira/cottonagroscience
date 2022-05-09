package com.lucasgteixeira.cottonagroscience.config;

import com.lucasgteixeira.cottonagroscience.model.Farmer;
import com.lucasgteixeira.cottonagroscience.model.Harvest;
import com.lucasgteixeira.cottonagroscience.repository.FarmerRepository;
import com.lucasgteixeira.cottonagroscience.repository.HarvestRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class mockDataConfig {
    @Bean
    CommandLineRunner commandLineRunner(FarmerRepository farmerRepository, HarvestRepository harvestRepository) {
        return args -> {
            Farmer Lucas = new Farmer(
                    "Lucas Teixeira",
                    LocalDate.of(2000, JANUARY, 5),
                    "Fazenda Salto-Firme",
                    "av. clara komar 254",
                    "(16)99788-5456",
                    "lucas@email.com",
                    "123"
            );

            Farmer Carlos = new Farmer(
                    "Carlos Henrique",
                    LocalDate.of(1980, FEBRUARY, 7),
                    "Fazenda Don Bosco",
                    "av. pergaminho floravante 74",
                    "(16)99755-6612",
                    "carlosh@email.com",
                    "345"
            );

            farmerRepository.saveAll(List.of(Lucas, Carlos));

            Harvest safraDB1 = new Harvest(
                    "Safra-0014",
                    "Arroz",
                    LocalDate.of(2022, MAY, 14),
                    LocalDate.of(2022, MAY, 16),
                    new BigDecimal("2.5"),
                    "Alta Fertilidade",
                    "Canadá",
                    new BigDecimal(2500),
                    "verão",
                    "Fazenda Salto-Firme",
                    "Enxofre",
                    "nenhum",
                    new BigDecimal("20.00"),
                    50,
                    BigDecimal.valueOf(300),
                    Lucas
            );

            Harvest safraDB2 = new Harvest(
                    "Safra-0015",
                    "Feijão",
                    LocalDate.of(2022, MAY, 17),
                    LocalDate.of(2022, MAY, 20),
                    new BigDecimal(10),
                    "Alta Fertilidade",
                    "EUA",
                    new BigDecimal(2500),
                    "verão",
                    "Fazenda Salto-Firme",
                    "Enxofre",
                    "nenhum",
                    new BigDecimal(15),
                    50,
                    new BigDecimal(400),
                    Lucas
            );

            harvestRepository.saveAll(List.of(safraDB1, safraDB2));
        };
    }
}
