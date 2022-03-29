package com.uwu.cst18013_spring;

import com.uwu.cst18013_spring.doctor.entity.Doctor;
import com.uwu.cst18013_spring.doctor.entity.DoctorCategory;
import com.uwu.cst18013_spring.doctor.entity.Vehicle;
import com.uwu.cst18013_spring.doctor.repo.DoctorCategoryRepository;
import com.uwu.cst18013_spring.doctor.repo.DoctorRepository;
import com.uwu.cst18013_spring.doctor.repo.QualificationRepository;
import com.uwu.cst18013_spring.doctor.repo.VehicleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class VehicleRepositoryTests {

    @Autowired
    private VehicleRepository vrepo;
    @Autowired
    private DoctorRepository repo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddVehicle() {
        Doctor doctor = repo.findById(1).get();
        Vehicle vehicle=new Vehicle("NP CAB3826 ","BMW");
        vrepo.save(vehicle);
        doctor.setVehicle(vehicle);
        repo.save(doctor);
    }
}
