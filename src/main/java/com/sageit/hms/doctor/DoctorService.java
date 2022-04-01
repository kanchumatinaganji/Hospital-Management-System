package com.sageit.hms.doctor;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sageit.hms.doctor.repo.DoctorRepository;
import com.sageit.hms.doctor.repo.QualificationRepository;
import com.sageit.hms.doctor.repo.VehicleRepository;
import com.sageit.hms.entity.Doctor;

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