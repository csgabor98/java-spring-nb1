package com.mink.javaspringnb1.Controllers;

import com.mink.javaspringnb1.Exceptions.ClubNotFoundException;
import com.mink.javaspringnb1.Exceptions.PlayerNotFoundException;
import com.mink.javaspringnb1.Exceptions.PostNotFoundException;
import com.mink.javaspringnb1.Models.Club;
import com.mink.javaspringnb1.Models.Player;
import com.mink.javaspringnb1.Models.Post;
import com.mink.javaspringnb1.Repositories.ClubRepository;
import com.mink.javaspringnb1.Repositories.PlayerRepository;
import com.mink.javaspringnb1.Repositories.PostRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ApiController {

    private final PlayerRepository playerRepository;
    private final ClubRepository clubRepository;
    private final PostRepository postRepository;

    ApiController(PlayerRepository playerRepository, ClubRepository clubRepository, PostRepository postRepository){
       this.playerRepository = playerRepository;
       this.clubRepository = clubRepository;
       this.postRepository = postRepository;
    }

    @GetMapping("/api/clubs")
    public Iterable<Club> clubs(){
        return clubRepository.findAll();
    }

    @GetMapping("/api/clubs/{id}")
    public Club club(@PathVariable int id){
        return clubRepository.findById(id).orElseThrow(() -> new ClubNotFoundException(id));
    }

    @GetMapping("/api/players")
    public Iterable<Player> players(){
        return playerRepository.findAll();
    }

    @GetMapping("/api/players/{id}")
    public Player player(@PathVariable int id){
        return playerRepository.findById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    @GetMapping("/api/posts")
    public Iterable<Post> posts(){
        return postRepository.findAll();
    }

    @GetMapping("/api/posts/{id}")
    public Post post(@PathVariable int id){
        return postRepository.findById(id).orElseThrow(() -> new PostNotFoundException(id));
    }
}
