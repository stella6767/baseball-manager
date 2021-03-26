package com.example.baseballex1.domain.field;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

import com.example.baseballex1.domain.team.Team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Field {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String name;
	
	@OneToOne(mappedBy = "field",cascade = CascadeType.REMOVE) //자식이므로, 애를 삭제했을 때 의미없는 부모필드도 같이 삭제하도록
	private Team team;//포린키는 DB에서 무조건 한쪽만 //전파속성을 안 주면, 연관관계에서 JPA가 어떻게 할지를 모르므로 삭제가 안됨.
	
    @CreationTimestamp
	private Timestamp createDate;
	
}
