package com.lucasgteixeira.cottonagroscience.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private String type;
    private LocalDate harvestBeginning;
    private LocalDate harvestEnding;
    private String groundType;
    private String destination;
    private BigDecimal harvestHectare;
    private String period;
    private String address;
    private String fertilizers;
    private BigDecimal priceForEachBag;
    private Integer bagQuantity;
    private BigDecimal profitMargin;

    @ManyToOne
    @JoinColumn(name = "farmer_id_fk")
    private Farmer farmer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getHarvestBeginning() {
        return harvestBeginning;
    }

    public void setHarvestBeginning(LocalDate harvestBeginning) {
        this.harvestBeginning = harvestBeginning;
    }

    public LocalDate getHarvestEnding() {
        return harvestEnding;
    }

    public void setHarvestEnding(LocalDate harvestEnding) {
        this.harvestEnding = harvestEnding;
    }

    public String getGroundType() {
        return groundType;
    }

    public void setGroundType(String groundType) {
        this.groundType = groundType;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public BigDecimal getHarvestHectare() {
        return harvestHectare;
    }

    public void setHarvestHectare(BigDecimal harvestHectare) {
        this.harvestHectare = harvestHectare;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFertilizers() {
        return fertilizers;
    }

    public void setFertilizers(String fertilizers) {
        this.fertilizers = fertilizers;
    }

    public BigDecimal getPriceForEachBag() {
        return priceForEachBag;
    }

    public void setPriceForEachBag(BigDecimal priceForEachBag) {
        this.priceForEachBag = priceForEachBag;
    }

    public Integer getBagQuantity() {
        return bagQuantity;
    }

    public void setBagQuantity(Integer bagQuantity) {
        this.bagQuantity = bagQuantity;
    }

    public BigDecimal getProfitMargin() {
        return profitMargin;
    }

    public void setProfitMargin(BigDecimal profitMargin) {
        this.profitMargin = profitMargin;
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Harvest harvest = (Harvest) o;
        return Objects.equals(id, harvest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
