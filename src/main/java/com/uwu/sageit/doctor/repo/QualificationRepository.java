package com.uwu.cst18013_spring.doctor.repo;

import com.uwu.cst18013_spring.doctor.entity.Qualification;
import org.springframework.data.repository.CrudRepository;

public interface QualificationRepository extends CrudRepository<Qualification,Integer> {
    public Long countById(int id);
}
