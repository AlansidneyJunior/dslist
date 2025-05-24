package com.alan.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alan.dslist.dto.GameDTO;
import com.alan.dslist.dto.GameMinDTO;
import com.alan.dslist.entities.Game;
import com.alan.dslist.projections.GameMinProjection;
import com.alan.dslist.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		Game game = gameRepository.findById(id).get();
		return new GameDTO(game);
	}
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll(){
		List<Game> games = gameRepository.findAll();
		return games.stream().map(game -> new GameMinDTO(game)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listId){
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(game -> new GameMinDTO(game)).toList();
	}
}
