package com.example.baseballex1.domain.player;

import java.sql.Timestamp;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

import org.hibernate.annotations.CreationTimestamp;

import com.example.baseballex1.domain.team.Team;
import com.example.baseballex1.web.dto.PositionDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@SqlResultSetMapping(
		name = "mPositionPlayer",
		classes = @ConstructorResult(
				targetClass = PositionDto.class,
				columns = {
						@ColumnResult(name = "position", type = String.class),
						@ColumnResult(name = "lotte", type = String.class),
						@ColumnResult(name = "hanhwa", type = String.class),
						@ColumnResult(name = "samsung", type = String.class)
				})
		)


@NamedNativeQuery(
        name = "mPositionPlayer",
        query = "SELECT position, " + 
        		"	MAX(IF(player.teamId = 1, player.name, \"\")) \"lotte\", " + 
        		"    MAX(IF(player.teamId = 2, player.name, \"\")) \"hanhwa\", " + 
        		"    MAX(IF(player.teamId = 3, player.name, \"\")) \"samsung\" " + 
        		"FROM player, team " + 
        		"WHERE player.teamId = team.id " + 
        		"GROUP BY position",
        resultSetMapping = "mPositionPlayer"
)




@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String name;
	
	private String position;
	
	@ManyToOne
	@JoinColumn(name = "teamId")
	private Team team;
	
    @CreationTimestamp
	private Timestamp createDate;
	
}
