package com.sageit.hms.doctor.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sageit.hms.entity.DoctorCategory;

public interface DoctorCategoryRepository extends JpaRepository<DoctorCategory,Integer> {
}
