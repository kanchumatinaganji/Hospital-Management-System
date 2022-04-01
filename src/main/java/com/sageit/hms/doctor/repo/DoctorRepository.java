package com.sageit.hms.doctor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sageit.hms.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    public Long countById(int id);
}
