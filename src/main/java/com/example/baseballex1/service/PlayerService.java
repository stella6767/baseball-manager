package com.example.baseballex1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.example.baseballex1.domain.player.Player;
import com.example.baseballex1.domain.player.PlayerRepository;
import com.example.baseballex1.domain.team.Team;
import com.example.baseballex1.domain.team.TeamRepository;
import com.example.baseballex1.query.PositionQuery;
import com.example.baseballex1.web.dto.PositionDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	
	private final PositionQuery positionQuery;


	@PersistenceContext
	private EntityManager em;
	
	
	public List<Team> 팀불러오기() {
		return teamRepository.findAll();
	}
	
	public void 선수등록(Player player, int teamId) {
		
		Team team = teamRepository.findById(teamId).get();
		player.setTeam(team);
		
		playerRepository.save(player);
	}
	
	public List<Player> 전체찾기(){
		
		return playerRepository.findAll();
	}
	
	public void 삭제하기(int id) {
		
		System.out.println("서비스에서 삭제 Id" + id);
		//Player player = playerRepository.findById(id).get(); //여기서 또 lazyloading인데 select 한번 더 하면서 getter를 때리면서 무한참조됨. 로그 하지마셈. 
		//System.out.println(player); 
		
		playerRepository.deleteById(id);
	
	}
	
	
//	public List<PositionDto> 포지션별선수() {	 //포기
//		JpaResultMapper jpaResultMapper = new JpaResultMapper();
//		List<PositionDto> positionDtos = jpaResultMapper.list(positionQuery.PostionPivot(), PositionDto.class);
//		return positionDtos;
//
//	}
	
	
	public List<PositionDto> 포지션별선수(){
		
		List<PositionDto> positionDtoList = em.createNamedQuery("mPositionPlayer").getResultList();

		return positionDtoList;
	}

	

}
