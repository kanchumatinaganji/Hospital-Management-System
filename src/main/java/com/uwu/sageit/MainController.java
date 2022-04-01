package com.uwu.cst18013_spring;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomePage(){
        return "index";
    }

    @GetMapping("/aboutus")
    public String showAboutUsPage(){
        return "aboutus";
    }

/*
    @PostMapping("login")
    public String showAdminPage(){
        User admin=new User();
        String email="admin@gmail.com";
        String pw="Abcd1234#";

        if(admin.getPassword()==pw && admin.getEmail()==email){
            return "doctors";
        }
        else{
            System.out.println("Incorrct Email or password");
            return "login";
        }
    }
    */

}
