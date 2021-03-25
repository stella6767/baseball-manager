package com.example.baseballex1.web.dto.player;

import com.example.baseballex1.domain.player.Player;

import lombok.Data;

@Data
public class PlayerSaveRepDto {
	
	private String name;
	private String position;
	private int teamId;
	
	public Player toEntity() {
		return Player.builder()
				.name(name)
				.position(position)
				.build();
	}
	
	
}
