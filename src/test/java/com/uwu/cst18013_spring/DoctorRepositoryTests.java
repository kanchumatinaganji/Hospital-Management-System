package com.uwu.cst18013_spring;

import com.uwu.cst18013_spring.doctor.entity.Doctor;
import com.uwu.cst18013_spring.doctor.entity.Qualification;
import com.uwu.cst18013_spring.doctor.entity.Vehicle;
import com.uwu.cst18013_spring.doctor.repo.DoctorRepository;
import com.uwu.cst18013_spring.doctor.repo.QualificationRepository;
import com.uwu.cst18013_spring.doctor.repo.VehicleRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DoctorRepositoryTests {
    @Autowired private DoctorRepository repo;

    @Autowired private QualificationRepository qrepo;

    @Autowired private VehicleRepository vrepo;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testAddNew(){
        Doctor doctor=new Doctor();
        doctor.setEmail("kavi@gmail.com");
        doctor.setPassword("kavi1234");
        doctor.setFirstName("Kavi");
        doctor.setLastName("Raj");
        doctor.setDescription("Heart Specialist");
        doctor.setTelno("0774512520");
        Doctor savedDoctor=repo.save(doctor);

        Assertions.assertThat(savedDoctor).isNotNull();
        Assertions.assertThat(savedDoctor.getId()).isGreaterThan(0);
    }


    @Test
    public void testListAll(){
        Iterable <Doctor> doctors=repo.findAll();
        Assertions.assertThat(doctors).hasSizeGreaterThan(0);

        for(Doctor doctor:doctors){
            System.out.println(doctor);
        }
    }

    @Test
    public void testUpdate(){
        int doctorId=4;
        Optional<Doctor> optionalDoctor=repo.findById(doctorId);
        Doctor doctor=optionalDoctor.get();
        doctor.setTelno("0771234567");
        repo.save(doctor);

        Doctor updatedDoctor=repo.findById(doctorId).get();
        Assertions.assertThat(updatedDoctor.getTelno()).isEqualTo("0771234567");
    }

    @Test
    public void testGet(){
        int doctorId=4;
        Optional<Doctor> optionalDoctor=repo.findById(doctorId);
        Assertions.assertThat(optionalDoctor).isPresent();
        System.out.println(optionalDoctor.get());
    }

    @Test
    public void testDelete(){
        int doctorId=6;
        repo.deleteById(doctorId);
        Optional<Doctor> optionalDoctor=repo.findById(doctorId);
        Assertions.assertThat(optionalDoctor).isNotPresent();
    }

    @Test
    public void testCreateQualifications(){
        Qualification qualificationDPM = new Qualification("DPM");
        //Qualification qualificationMD = new Qualification("MD");
        //Qualification qualificationMSurg = new Qualification("MSurg");

        entityManager.persist(qualificationDPM);
        //entityManager.persist(qualificationMD);
        //entityManager.persist(qualificationMSurg);

    }

    @Test
    public void testCreateNewDoctorWithOneQualification(){
        Qualification qualificationMBBS=entityManager.find(Qualification.class,1);
        Doctor doctor=new Doctor("anu@gmail.com","Abcd1234#","Anu","Raam","0754152021"," h hj");
        doctor.addQualification(qualificationMBBS);

        repo.save(doctor);
    }

    @Test
    public void testCreateNewDoctorWithMoreQualification(){
        Qualification qualificationMD=entityManager.find(Qualification.class,2);
        Qualification qualificationMSurg=entityManager.find(Qualification.class,3);
        Doctor doctor=new Doctor("mala@gmail.com","Abcd1234#","Mala","Raja","0774512520"," hbhj hj");
        doctor.addQualification(qualificationMD);
        doctor.addQualification(qualificationMSurg);
        repo.save(doctor);
    }

    @Test
    public void testAssignRoleToExistingDoctor(){
        Doctor doctor=repo.findById(3).get();
        Qualification qualificationMBBS=entityManager.find(Qualification.class,1);
        Qualification qualificationMSurg=entityManager.find(Qualification.class,3);
        doctor.addQualification(qualificationMBBS);
        doctor.addQualification(qualificationMSurg);
        repo.save(doctor);
    }

    @Test
    public void testRemoveRoleFromExistingDoctor(){
        Doctor doctor=repo.findById(3).get();
        Qualification qualification=new Qualification(3);
        doctor.removeQualification(qualification);
    }

    @Test
    public void testCreateNewDoctorwithNewQualification(){
        Qualification qualificationMPhil = new Qualification("MPhil");
        Doctor doctor=new Doctor("kala@gmail.com","Abcd1234#","Kala","Raja","0774512520"," hbhj hj");
        doctor.addQualification(qualificationMPhil);
        repo.save(doctor);
    }

    @Test
    public void testGetDoctor(){
        Doctor doctor=repo.findById(8).get();
        System.out.println(doctor.getFirstName()+" "+doctor.getLastName());
        System.out.println(doctor.getQualifications());
    }

}
