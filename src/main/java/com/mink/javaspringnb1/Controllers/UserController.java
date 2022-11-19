package com.mink.javaspringnb1.Controllers;

import com.mink.javaspringnb1.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/admin/users")
    public String users(Model model, String msg) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("msg", model.getAttribute("msg"));
        return "users";
    }

    @GetMapping("/admin/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") int id, RedirectAttributes redirAttr) {
        redirAttr.addFlashAttribute("msg","Felhasználó törölve! ID="+userRepository.findById(id).get().getId());
        userRepository.delete(userRepository.findById(id).get());
        return "redirect:/admin/users";
    }

}
