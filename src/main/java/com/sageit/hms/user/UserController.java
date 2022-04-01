package com.sageit.hms.user;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/admin_home")
    public String adminHome(){
        return "admin_home.html";
    }

    @GetMapping("/login")
    public ModelAndView login() {
    	System.out.println("login");
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("user", new User());
        return mav;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, RedirectAttributes ra ) {
        User oauthUser = userService.userlogin(user.getEmail(), user.getPassword());
        System.out.print(oauthUser);
        if(Objects.nonNull(oauthUser)) {
                return "admin_home.html";
        }
        else {
            ra.addFlashAttribute("error","Incorrect Email or Password ");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logout() {
        return "index";
    }

/*
    @RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
    public String logoutDo(HttpServletRequest request,HttpServletResponse response)
    {
        return "redirect:/login";
    }
*/
}