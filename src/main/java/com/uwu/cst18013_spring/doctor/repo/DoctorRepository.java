package com.uwu.cst18013_spring.doctor.repo;

import com.uwu.cst18013_spring.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    public Long countById(int id);
}
