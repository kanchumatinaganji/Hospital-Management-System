package com.uwu.cst18013_spring.doctor.entity;

import javax.persistence.*;

@Entity
public class DoctorCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=50, nullable = false,unique = true)
    private String name;

    public DoctorCategory(){}
    public DoctorCategory(int id) {
        this.id = id;
    }
    public DoctorCategory(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
