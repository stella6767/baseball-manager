package com.example.baseballex1.domain.team;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.example.baseballex1.domain.field.Field;
import com.example.baseballex1.domain.player.Player;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Team { //팀을 뿌릴 때 선수도 같이 뿌릴 일 없으니까, 양방향 맵핑 안 걸어도 됨. 

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String name;
	
	@OneToOne(cascade = CascadeType.DETACH) //detach는 field가 삭제되어도 아무런 변화를 일으키지 말라는 뜻.
	@JoinColumn(name = "fieldId")
	private Field field;
	
	@Transient //이렇게 하면 DTO 안 만들 수 있음. 근데 안 쓸거임
	private int fieldId;
	
    @CreationTimestamp
	private Timestamp createDate;
	
}
