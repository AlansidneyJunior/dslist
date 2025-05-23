package com.alan.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alan.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long>{

}
