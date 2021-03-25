<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>NO</th>
				<th>팀 이름</th>
				<th>구장</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="team" items="${teams}">
				<tr id="tr-${team.id}">
					<td>${team.id }</td>
					<td>${team.name }</td>
					<td>${team.field.name }</td>
					<td><button class="btn btn-danger" onclick="deleteById(${team.id})">삭제</button></td>
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
		url:"/team/"+id,
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