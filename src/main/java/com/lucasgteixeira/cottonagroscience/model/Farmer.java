package com.lucasgteixeira.cottonagroscience.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate dob;
    @Column(nullable = false)
    private String properties;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String password;

    public Farmer(String name, LocalDate dob, String properties, String address, String phone, String email, String password) {
        this.name = name;
        this.dob = dob;
        this.properties = properties;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public Farmer(Long id, String name, LocalDate dob, String properties, String address, String phone, String email, String password) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Farmer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", properties='" + properties + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
