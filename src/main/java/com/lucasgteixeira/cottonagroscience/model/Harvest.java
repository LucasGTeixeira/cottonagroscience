package com.lucasgteixeira.cottonagroscience.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table
public class Harvest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String type;
    @Column(nullable = false)
    private LocalDate harvestBeginning;
    @Column(nullable = false)
    private LocalDate harvestEnding;
    @Column(nullable = false)
    private BigDecimal harvestTime;
    @Column(nullable = false)
    private String groundType;
    @Column(nullable = false)
    private String destination;
    @Column(nullable = false)
    private BigDecimal harvestHectare;
    @Column(nullable = false)
    private String period;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String fertilizers;
    @Column(nullable = false)
    private String pesticides;
    @Column(nullable = false)
    private BigDecimal priceForEachBag;
    @Column(nullable = false)
    private Integer bagQuantity;
    @Column(nullable = false)
    private BigDecimal profitMargin;
    @Column(nullable = false)
    private Integer ownerId;

    public Harvest() {
    }

    public Harvest(Long id, String name, String type, LocalDate harvestBeginning, LocalDate harvestEnding, BigDecimal harvestTime, String groundType, String destination, BigDecimal harvestHectare, String period, String address, String fertilizers, String pesticides, BigDecimal priceForEachBag, Integer bagQuantity, BigDecimal profitMargin, Integer ownerId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.harvestBeginning = harvestBeginning;
        this.harvestEnding = harvestEnding;
        this.harvestTime = harvestTime;
        this.groundType = groundType;
        this.destination = destination;
        this.harvestHectare = harvestHectare;
        this.period = period;
        this.address = address;
        this.fertilizers = fertilizers;
        this.pesticides = pesticides;
        this.priceForEachBag = priceForEachBag;
        this.bagQuantity = bagQuantity;
        this.profitMargin = profitMargin;
        this.ownerId = ownerId;
    }

    public Harvest(String name, String type, LocalDate harvestBeginning, LocalDate harvestEnding, BigDecimal harvestTime, String groundType, String destination, BigDecimal harvestHectare, String period, String address, String fertilizers, String pesticides, BigDecimal priceForEachBag, Integer bagQuantity, BigDecimal profitMargin, Integer ownerId) {
        this.name = name;
        this.type = type;
        this.harvestBeginning = harvestBeginning;
        this.harvestEnding = harvestEnding;
        this.harvestTime = harvestTime;
        this.groundType = groundType;
        this.destination = destination;
        this.harvestHectare = harvestHectare;
        this.period = period;
        this.address = address;
        this.fertilizers = fertilizers;
        this.pesticides = pesticides;
        this.priceForEachBag = priceForEachBag;
        this.bagQuantity = bagQuantity;
        this.profitMargin = profitMargin;
        this.ownerId = ownerId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

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

    public BigDecimal getHarvestTime() {
        return harvestTime;
    }

    public void setHarvestTime(BigDecimal harvestTime) {
        this.harvestTime = harvestTime;
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

    public String getPesticides() {
        return pesticides;
    }

    public void setPesticides(String pesticides) {
        this.pesticides = pesticides;
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

    @Override
    public String toString() {
        return "Harvest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", harvestBeginning=" + harvestBeginning +
                ", harvestEnding=" + harvestEnding +
                ", harvestTime=" + harvestTime +
                ", groundType='" + groundType + '\'' +
                ", Destination='" + destination + '\'' +
                ", harvestHectare=" + harvestHectare +
                ", period='" + period + '\'' +
                ", address='" + address + '\'' +
                ", fertilizers='" + fertilizers + '\'' +
                ", pesticides='" + pesticides + '\'' +
                ", priceForEachBag=" + priceForEachBag +
                ", bagQuantity=" + bagQuantity +
                ", profitMargin=" + profitMargin +
                ", owner=" + ownerId +
                '}';
    }
}
