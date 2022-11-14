package com.mink.javaspringnb1.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/teams")
    public String teams() {
        return "teams";
    }

    @GetMapping("/players")
    public String players() {
        return "players";
    }
}
