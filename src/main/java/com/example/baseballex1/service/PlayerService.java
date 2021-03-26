package com.example.baseballex1.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseballex1.domain.player.Player;
import com.example.baseballex1.domain.player.PlayerRepository;
import com.example.baseballex1.domain.team.Team;
import com.example.baseballex1.domain.team.TeamRepository;
import com.example.baseballex1.web.dto.PlayerPositionRespDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerRepository playerRepository;
	private final TeamRepository teamRepository;
	
	private final EntityManager entityManager;
	
	@Transactional(readOnly = true)
	public List<Team> 팀불러오기() {
		return teamRepository.findAll();
	}
	
	@Transactional
	public void 선수등록(Player player, int teamId) {
		
		Team team = teamRepository.findById(teamId).get();
		player.setTeam(team);
		
		playerRepository.save(player);
	}
	@Transactional(readOnly = true)
	public List<Player> 전체찾기(){
		
		return playerRepository.findAll();
	}
	
	@Transactional
	public void 삭제하기(int id) {
		
		System.out.println("서비스에서 삭제 Id" + id);
		//Player player = playerRepository.findById(id).get(); //lazyloading인데 여기서 또 select 한번 더 하면서 getter를 때리면서 무한참조필드도 getter 때림. 로그 하지마셈. 
		//System.out.println(player); 
		
		playerRepository.deleteById(id);
	}
	
	
	@Transactional(readOnly = true)
	public List<PlayerPositionRespDto> 포지션별선수리스트() {	 
		StringBuffer sb = new StringBuffer(); //여러명이서 같이쓰는 건 버퍼로 동시접근불가능하게
		//sb.append("SELECT * FROM ");
		//sb.append("( ");
		
		sb.append("SELECT ");
		sb.append("position, ");
		sb.append("MAX(if(teamid=1, name, \"\")) LG, ");
		sb.append("MAX(if(teamid=2, name, \"\")) LOTTE, ");
		sb.append("MAX(if(teamid=3, name, \"\")) SAMSUNG ");
		sb.append("from player ");
		sb.append("group by position ");
		//sb.append(") ");		
		
		Query q =entityManager.createNativeQuery(sb.toString());
		
		JpaResultMapper result = new JpaResultMapper();
		
		List<PlayerPositionRespDto> playerPositionRespDto = result.list(q, PlayerPositionRespDto.class);
		return playerPositionRespDto;
	}
	
	
	

	

}
