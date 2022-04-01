package com.uwu.cst18013_spring.doctor.entity;

import javax.persistence.*;

@Entity
@Table(name="vehicle")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(length = 20, nullable = false, unique = true)
    private String vehicleNo;

    @Column(length = 30, nullable = false)
    private String vehicleModel;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "vehicle")
    public Doctor doctor;

    public Vehicle(){}
    public Vehicle(String vehicleNo, String vehicleModel) {
        this.vehicleNo = vehicleNo;
        this.vehicleModel = vehicleModel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}