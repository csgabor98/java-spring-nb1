package com.mink.javaspringnb1.Repositories;

import com.mink.javaspringnb1.Models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Integer> {
}
