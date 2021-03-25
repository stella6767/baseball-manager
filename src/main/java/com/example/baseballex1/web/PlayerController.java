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
import com.example.baseballex1.domain.player.Player;
import com.example.baseballex1.domain.player.PlayerRepository;
import com.example.baseballex1.service.PlayerService;
import com.example.baseballex1.web.dto.CMRespDto;
import com.example.baseballex1.web.dto.PositionDto;
import com.example.baseballex1.web.dto.player.PlayerSaveRepDto;
import com.example.baseballex1.web.dto.team.TeamSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	
	@GetMapping("/playerAdd") 
	public String playerAdd(Model model) {
		model.addAttribute("teams",playerService.팀불러오기());		
		return "player/playerAdd";
	}
	
	
	@PostMapping("/player") // 팀 등록하기
	public String save(PlayerSaveRepDto playerSaveRepDto, Model model) {
		
		playerService.선수등록(playerSaveRepDto.toEntity(), playerSaveRepDto.getTeamId());

		return "redirect:/player";
	}
	
	
	@GetMapping("/player") 
	public String playerList(Model model) {
		model.addAttribute("players",playerService.전체찾기());		
		return "player/playerManage";
	}
	
	
	@DeleteMapping("/player/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id){ //자바스크립트 요청 시 무적권 @ReasponseBody 요청		
		System.out.println("삭제ID: " + id);
		playerService.삭제하기(id);
		
		return new CMRespDto<>(1,null);
		
	}
	
	
	@GetMapping("/position") 
	public String positionplayer(Model model) {
		List<PositionDto> positionDtos = playerService.포지션별선수();
		model.addAttribute("positionDtos", positionDtos);
		
		return "player/positionPlayer";
	}
	
	
	
	

}
