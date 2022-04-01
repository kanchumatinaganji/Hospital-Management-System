package com.uwu.cst18013_spring.doctor;
import com.uwu.cst18013_spring.doctor.entity.Qualification;
import com.uwu.cst18013_spring.doctor.entity.Vehicle;
import com.uwu.cst18013_spring.doctor.repo.QualificationRepository;
import com.uwu.cst18013_spring.doctor.repo.VehicleRepository;
import org.springframework.stereotype.Service;
import com.uwu.cst18013_spring.doctor.entity.Doctor;
import com.uwu.cst18013_spring.doctor.repo.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doc_repo;

    @Autowired
    private QualificationRepository qua_repo;

    @Autowired
    private VehicleRepository veh_repo;

    public List<Doctor> listAll(){
        return (List<Doctor>) doc_repo.findAll();
    }

    public void save(Doctor doctor) {
        doc_repo.save(doctor);
    }

    public Doctor get(int id) throws DoctorNotFoundException {
        Optional<Doctor> result=doc_repo.findById(id);
        if(result.isPresent()){
            return result.get();
        }
        throw new DoctorNotFoundException("Could not find any doctor with this id "+id);
    }

    public void  delete(int id) throws DoctorNotFoundException {
        Long count=doc_repo.countById(id);
        if(count==null ||count==0){
            throw new DoctorNotFoundException("Could not find any doctor with this id "+id);
        }
        doc_repo.deleteById(id);
    }
}