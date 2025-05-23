package com.alan.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alan.dslist.dto.GameListDTO;
import com.alan.dslist.entities.GameList;
import com.alan.dslist.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional
	public GameListDTO findById(Long id) {
		GameList gameList = gameListRepository.findById(id).get();
		return new GameListDTO(gameList);
	}
	
	@Transactional
	public List<GameListDTO> findAll(){
		List<GameList> gameLists = gameListRepository.findAll();
		return gameLists.stream().map(gameList -> new GameListDTO(gameList)).toList();
	}
}
