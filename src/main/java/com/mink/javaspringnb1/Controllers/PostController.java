package com.mink.javaspringnb1.Controllers;

import com.mink.javaspringnb1.Models.Post;
import com.mink.javaspringnb1.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PostController{

    @Autowired
    PostRepository postRepository;

    @GetMapping("/posts/new")
    public String newClub(Model model) {
        model.addAttribute("post", new Post());
        return "new_post";
    }

    @PostMapping("/post/new")
    public String submitClub(@Valid @ModelAttribute Post post, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()){
            return "new_post";
        }
        postRepository.save(post);
        return "redirect:/players";
    }

}
