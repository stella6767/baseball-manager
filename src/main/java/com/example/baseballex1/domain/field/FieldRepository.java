
package com.example.baseballex1.domain.field;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FieldRepository extends JpaRepository<Field, Integer> {
	
	//자꾸 까먹네 null은 is, is not 으로 체크하는 거 까먹지 말자.
//	@Query(value = "select * from field where teamId is null", nativeQuery = true)
//	List<Field> mSelectField();
	

}
