package com.uwu.cst18013_spring.doctor;

import com.uwu.cst18013_spring.doctor.entity.Doctor;
import com.uwu.cst18013_spring.doctor.DoctorService;
import com.uwu.cst18013_spring.doctor.entity.DoctorCategory;
import com.uwu.cst18013_spring.doctor.entity.Qualification;
import com.uwu.cst18013_spring.doctor.entity.Vehicle;
import com.uwu.cst18013_spring.doctor.repo.DoctorCategoryRepository;
import com.uwu.cst18013_spring.doctor.repo.QualificationRepository;
import com.uwu.cst18013_spring.doctor.repo.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DoctorController {
    @Autowired
    private DoctorService docService;
    @Autowired
    private QualificationRepository qua_repo;
    @Autowired
    private DoctorCategoryRepository cat_repo;
    @Autowired
    private VehicleRepository veh_repo;

    @GetMapping("/doctors")
    public String showDoctorList(Model model){
    	System.out.println("--------showDoctorList--------- ");
        List<Doctor> listDoctors=docService.listAll();
        System.out.println("------------------------ "+listDoctors.toString());
        model.addAttribute("listDoctors",listDoctors);
        List<DoctorCategory> listDoctorCategories=cat_repo.findAll();
        System.out.println("------------------------ "+listDoctorCategories);
        model.addAttribute("listDoctorCategories",listDoctorCategories);
        return "doctors";
    }

    @GetMapping("/doctors/new")
    public String showNewForm(Model model){
        List<Qualification> listQualifications= (List<Qualification>) qua_repo.findAll();
        List<DoctorCategory> listDoctorCategories=cat_repo.findAll();

        model.addAttribute("doctor",new Doctor());
        model.addAttribute("pageTitle","Add New Doctor");
        model.addAttribute("listQualifications",listQualifications);
        model.addAttribute("listDoctorCategories",listDoctorCategories);

        return "doctor_form";
    }

    @PostMapping("/doctor/save")
    public String saveDoctor (Doctor doctor, RedirectAttributes ra){
        doctor.setPassword("Abcd1234#");
        docService.save(doctor);
        ra.addFlashAttribute("message","The doctor has been saved successfully!");
        return "redirect:/doctors";
    }

    @GetMapping("doctors/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, RedirectAttributes ra){
        try {
            Doctor doctor=docService.get(id);
            model.addAttribute("doctor",doctor );
            model.addAttribute("pageTitle","Edit Doctor (ID:"+id+")");
            ra.addFlashAttribute("message","The  doctor ID "+id+" has been updated successfully!");

            List<Qualification> listQualifications= (List<Qualification>) qua_repo.findAll();
            List<DoctorCategory> listDoctorCategories=cat_repo.findAll();

            model.addAttribute("listQualifications",listQualifications);
            model.addAttribute("listDoctorCategories",listDoctorCategories);
            docService.save(doctor);
            return "doctor_form";
        } catch (DoctorNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
            return "redirect:/doctors";
        }

    }


    @GetMapping("doctors/delete/{id}")
    public String deleteDoctor(@PathVariable("id") int id, Model model,RedirectAttributes ra){
        try {
            docService.delete(id);
            ra.addFlashAttribute("message","This doctor ID "+ id + " has been deleted successfully!");

        } catch (DoctorNotFoundException e) {
            ra.addFlashAttribute("message",e.getMessage());
        }
        return "redirect:/doctors";
    }

}

