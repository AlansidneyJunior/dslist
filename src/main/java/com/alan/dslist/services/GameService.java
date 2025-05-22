package com.alan.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alan.dslist.dto.GameMinDTO;
import com.alan.dslist.entities.Game;
import com.alan.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){
		List<Game> gameList = gameRepository.findAll();
		return gameList.stream().map(game -> new GameMinDTO(game)).toList();
	}
}
