<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">
	<table class="table">
		<thead>
			<tr>
				<th>포지션</th>
				<th>롯데</th>
				<th>NC</th>
				<th>기아</th>
<!-- 				<th>해태</th> -->
			</tr>
		</thead>
		<tbody id="tbody">
			<c:forEach var="positionDto" items="${positionDtos}">
				<tr>
					<td>${positionDto.position}</td>
					<td>${positionDto.lotte}</td>
					<td>${positionDto.hanhwa}</td>
					<td>${positionDto.samsung}</td>
			<%-- 		<td>${positionDto.HaeTae}</td> --%>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


</body>
<script>
	
</script>

</html>