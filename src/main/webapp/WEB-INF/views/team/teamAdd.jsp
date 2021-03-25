<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">
	<form action="/team" method="post">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">팀 이름</span>
			</div>
			<input name="name" type="text" class="form-control" style="width: 50%" placeholder="팀 이름을 입력해주세요"
				required="required">
			<div class="input-group-prepend">

				<span class="input-group-text">구장 이름</span>
			</div>
			<select name="fieldId" required="required">
				<option value="">선택</option>
				<c:forEach var="field" items="${selectFields}">
					<option value="${field.id}">${field.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="text-center">
			<input class="btn btn-outline-primary" type="submit" value="등록하기">
		</div>
	</form>
</div>


</body>
<script>
	
</script>

</html>