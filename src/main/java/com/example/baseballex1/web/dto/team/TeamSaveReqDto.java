package com.example.baseballex1.web.dto.team;

import com.example.baseballex1.domain.field.Field;
import com.example.baseballex1.domain.team.Team;

import lombok.Data;

@Data
public class TeamSaveReqDto {

	private String name;
	private int fieldId;

	public Team toEntity() {
		return Team.builder().name(name).build();
	}

}
