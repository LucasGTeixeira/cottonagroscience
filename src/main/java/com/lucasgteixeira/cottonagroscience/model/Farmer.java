package com.lucasgteixeira.cottonagroscience.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Entity
@Table
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate dob;
    private String properties;
    private String address;
    private String phone;
    private String email;
    private String password;

    @OneToMany(mappedBy = "owner")
    private List<Harvest> harvests;

    public Farmer(String name, LocalDate dob, String properties, String address, String phone, String email, String password) {
        this.name = name;
        this.dob = dob;
        this.properties = properties;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Farmer() {
    }

    public String getPassword() {
        return password;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public List<Harvest> getHarvests() {
        return harvests;
    }

    public void setHarvests(List<Harvest> harvests) {
        this.harvests = harvests;
    }

    @OneToMany(mappedBy = "owner")
    private Collection<Harvest> harvest;

    public Collection<Harvest> getHarvest() {
        return harvest;
    }

    public void setHarvest(Collection<Harvest> harvest) {
        this.harvest = harvest;
    }
}
