package com.uwu.cst18013_spring.doctor.repo;

import com.uwu.cst18013_spring.doctor.entity.DoctorCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorCategoryRepository extends JpaRepository<DoctorCategory,Integer> {
}
