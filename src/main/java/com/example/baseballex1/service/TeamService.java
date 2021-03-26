package com.example.baseballex1.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseballex1.domain.field.Field;
import com.example.baseballex1.domain.field.FieldRepository;
import com.example.baseballex1.domain.team.Team;
import com.example.baseballex1.domain.team.TeamRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TeamService {
	
	private final TeamRepository teamRepository;
	private final FieldRepository fieldRepository;
	
	
	@Transactional(readOnly = true)
	public List<Field> 선택가능야구장() {
		
		List<Field> fieldList = new ArrayList<>();
		
		List<Field> filedsEntity = fieldRepository.findAll();
		
		for (Field field: filedsEntity) {
			if(field.getTeam() == null) {
				fieldList.add(field);
			}
		}
		
		return fieldList;
	}
	
	
	@Transactional
	public void 팀등록(Team team, int fieldId) { 
		
		Field field = fieldRepository.findById(fieldId).get();
		
		team.setField(field);		
		
		System.out.println("저장할 팀: "+ team);
		
		teamRepository.save(team);
	}
	
	
	@Transactional(readOnly = true)
	public List<Team> 전체찾기(){
		return teamRepository.findAll();
	}
	
	
	@Transactional
	public void 삭제하기(int id) {
		
		teamRepository.deleteById(id);
	
	}
	
	
}
