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
import com.example.baseballex1.service.FieldService;
import com.example.baseballex1.web.dto.CMRespDto;
import com.example.baseballex1.web.dto.field.FieldSaveReqDto;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class FieldController {
	
	private final FieldService fieldService;

	
	@GetMapping("/fieldAdd") //야구장 등록페이지
	public String field() {
		return "/field/fieldAdd";
	}
	
	
	
	@PostMapping("/filed") // 야구장 등록하기
	public String save(FieldSaveReqDto fieldSaveReqDto, Model model) {
		
		System.out.println("들어옴?" + fieldSaveReqDto);

		fieldService.야구장등록(fieldSaveReqDto.toEntity());

		return "redirect:/field";
	}
	
	
	@GetMapping("/field") //야구장 등록페이지
	public String findAll(Model model) {
		
		List<Field> fields = fieldService.전체찾기();
		
		model.addAttribute("fields",fields);
		
		
		return "/field/fieldManage";
	}
	
	
	@DeleteMapping("/field/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable int id){
		
		System.out.println("삭제ID: " + id);
		fieldService.삭제하기(id);
		
		return new CMRespDto<>(1,null);
		
	}
	
	

}
