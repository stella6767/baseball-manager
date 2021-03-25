<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">
	<table class="table table-hover">
		<thead>
			<tr>
				<th>NO</th>
				<th>구장</th>
				<th>팀</th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="field" items="${fields}">
				<tr id="tr-${field.id}">
					<td>${field.id }</td>
					<td>${field.name }</td>
					<td>${field.team.name}</td>
					<td><button class="btn btn-danger" onclick="deleteById(${field.id})">삭제</button></td>
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
		url:"/field/"+id,
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