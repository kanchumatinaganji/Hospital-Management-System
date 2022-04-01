package com.sageit.hms.doctor.repo;

import org.springframework.data.repository.CrudRepository;

import com.sageit.hms.entity.Qualification;

public interface QualificationRepository extends CrudRepository<Qualification,Integer> {
    public Long countById(int id);
}
