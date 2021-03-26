package com.example.baseballex1.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.baseballex1.domain.field.Field;
import com.example.baseballex1.domain.field.FieldRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class FieldService {
	
	private final FieldRepository fieldRepository;
	
	@Transactional
	public Field 야구장등록(Field field) {	
		return fieldRepository.save(field);
	}
	@Transactional(readOnly = true)
	public List<Field> 전체찾기(){
		return fieldRepository.findAll();
	}

	@Transactional
	public void 삭제하기(int fieldId) {
		
		fieldRepository.deleteById(fieldId);
	}
	

}
