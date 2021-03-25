<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th>NO</th>
				<th>선수 이름</th>
				<th>포지션</th>
				<th>팀</th>
				<th></th>
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach var="player" items="${players}">
				<tr id="tr-${player.id}">
					<td>${player.id}</td>
					<td>${player.name}</td>
					<td>${player.position}</td>
					<td>${player.team.name }</td>
					<td><button class="btn btn-danger" onclick="deleteById(${player.id})">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


</body>
<script>
function deleteById(id){
	console.log(id);		
	$.ajax({
		type:"DELETE",
		url:"/player/"+id,
		dataType:"JSON"	
	}).done((res)=>{
		console.log(res);
 		if(res.statusCode === 1){		
			$("#tr-"+id).remove();
		}else{ 
			alert("삭제에 실패하였습니다.");
		}	 
	});
	
}

</script>

</html>