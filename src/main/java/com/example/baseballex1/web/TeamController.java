package com.example.baseballex1.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.baseballex1.domain.field.Field;
import com.example.baseballex1.domain.team.Team;
import com.example.baseballex1.service.TeamService;
import com.example.baseballex1.web.dto.CMRespDto;
import com.example.baseballex1.web.dto.field.FieldSaveReqDto;
import com.example.baseballex1.web.dto.team.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class TeamController {
	
	private final TeamService teamService;
	
	
	@GetMapping("/teamAdd") //팀 등록페이지, 여기서 팀없는 야구장도 선택하도록	
	public String field(Model model) {
		
		List<Field> selectFields = teamService.선택가능야구장();
		
		model.addAttribute("selectFields",selectFields);
		
		return "/team/teamAdd";
	}
	
	
	
	@PostMapping("/team") // 팀 등록하기
	public String save(TeamSaveReqDto teamSaveReqDto, Model model) {
		
		System.out.println("들어옴?" + teamSaveReqDto);
		teamService.팀등록(teamSaveReqDto.toEntity(), teamSaveReqDto.getFieldId());

		return "redirect:/team";
	}

	
	@GetMapping("/team") //팀 리스트
	public String findAll(Model model) {
		
		List<Team> teams= teamService.전체찾기();
		
		model.addAttribute("teams",teams);
		
		return "/team/teamManage";
	}

	
	
	@DeleteMapping("/team/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id){
		
		System.out.println("삭제ID: " + id);
		teamService.삭제하기(id);
		
		return new CMRespDto<>(1,null);
		
	}
}
