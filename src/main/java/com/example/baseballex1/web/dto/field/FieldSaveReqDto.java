package com.example.baseballex1.web.dto.field;

import com.example.baseballex1.domain.field.Field;

import lombok.Data;

@Data
public class FieldSaveReqDto {

	private String name;
	

	public Field toEntity() {
		return Field.builder()
				.name(name)
				.build();
	}
	
}
