package com.sageit.hms.doctor.repo;

import org.springframework.data.repository.CrudRepository;

import com.sageit.hms.entity.Vehicle;

public interface VehicleRepository extends CrudRepository<Vehicle,Integer> {
}
