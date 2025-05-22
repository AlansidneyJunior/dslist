package com.alan.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alan.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long>{

}
