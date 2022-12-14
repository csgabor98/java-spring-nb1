package com.mink.javaspringnb1.Controllers;

import com.mink.javaspringnb1.Models.Player;
import com.mink.javaspringnb1.Repositories.ClubRepository;
import com.mink.javaspringnb1.Repositories.PlayerRepository;
import com.mink.javaspringnb1.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

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
        model.addAttribute("msg", model.getAttribute("msg"));
        return "players";
    }

    @GetMapping("/players/new")
    public String newPlayer(Model model) {
        model.addAttribute("posts", postRepository.findAll());
        model.addAttribute("clubs", clubRepository.findAll());
        model.addAttribute("player", new Player());
        return "new_player";
    }

    @PostMapping("/player/new")
    public String submitPlayer(@Valid @ModelAttribute Player player, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("posts", postRepository.findAll());
            model.addAttribute("clubs", clubRepository.findAll());
            return "new_player";
        }
        playerRepository.save(player);
        return "redirect:/players";
    }

    @GetMapping("/players/delete/{id}")
    public String deletePlayer(@PathVariable(name = "id") int id, RedirectAttributes redirAttr) {
        redirAttr.addFlashAttribute("msg", "J??t??kos t??r??lve! ID=" + playerRepository.findById(id).get().getId());
        playerRepository.delete(playerRepository.findById(id).get());
        return "redirect:/players";
    }

}
