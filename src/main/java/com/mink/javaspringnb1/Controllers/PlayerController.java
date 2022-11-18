package com.mink.javaspringnb1.Controllers;

import com.mink.javaspringnb1.Models.Player;
import com.mink.javaspringnb1.Repositories.ClubRepository;
import com.mink.javaspringnb1.Repositories.PlayerRepository;
import com.mink.javaspringnb1.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {

    @Autowired
    private PlayerRepository playerRepository;
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
    private PostRepository postRepository;

    @GetMapping("/players")
    public String players(Model model) {
        model.addAttribute("players", playerRepository.findAll());
        return "players";
    }

    @GetMapping("/players/new")
    public String newPlayer(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("clubs", clubRepository.findAll());
        model.addAttribute("player", new Player());
        return "new_player";
    }

    @PostMapping("/new")
    public String submitPlayer(@ModelAttribute Player player, Model model) {
        playerRepository.save(player);
        return "redirect:players";
    }

}
