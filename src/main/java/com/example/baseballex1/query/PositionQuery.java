package com.example.baseballex1.query;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PositionQuery {

	private final EntityManager em;
	
	public Query PostionPivot() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("select position as position, ");  //이해를 못하겠네..
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 1 THEN p.name ELSE null END)) as lotte,  ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 2 THEN p.name ELSE null END)) as nc, ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 3 THEN p.name ELSE null END)) as kia, ");
		sb.append("GROUP_CONCAT((CASE WHEN p.teamId = 4 THEN p.name ELSE null END)) as HaeTae ");
		sb.append("from player GROUP BY position");
		
		Query query = em.createNativeQuery(sb.toString());		
		return query;
	}
}
