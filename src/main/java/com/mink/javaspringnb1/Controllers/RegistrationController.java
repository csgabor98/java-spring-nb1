package com.mink.javaspringnb1.Controllers;

import com.mink.javaspringnb1.Models.Role;
import com.mink.javaspringnb1.Models.User;
import com.mink.javaspringnb1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/registration")
    public String registration(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("msg", model.getAttribute("msg"));
        return "registration";
    }
    @PostMapping("/registration/new")
    public String submitRegistration(@ModelAttribute User user, Model model, RedirectAttributes redirectAttributes){
        for(User u: userRepository.findAll())
            if(u.getEmail().equals(user.getEmail())){
                redirectAttributes.addFlashAttribute("msg", "A regisztrációs email már foglalt!");
                return "/registration";
            }
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Role role = new Role();

        role.setId(3); role.setName("ROLE_USER");
        List<Role> rolelist = new ArrayList<Role>();
        rolelist.add(role);
        user.setRoles(rolelist);
        userRepository.save(user);
        model.addAttribute("id", user.getId());

        return "redirect:/login";
    }
}
