<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>


<div class="container">
	<form action="/player" method="post">
		<div class="input-group mb-3">
			<div class="input-group-prepend">
				<span class="input-group-text">선수 이름</span>
			</div>
			<input name="name" type="text" class="form-control" style="width: 50%"
				placeholder="선수 이름을 입력해주세요" required="required">
			<div class="input-group-prepend">
				<span class="input-group-text">포지션</span>
			</div>
			<select name="position" required="required">
				<option value="">선택</option>
				<option value="투수">투수</option>
				<option value="내야수">내야수</option>
				<option value="외야수">외야수</option>
				<option value="포수">포수</option>
			</select>
			<div class="input-group-prepend">
				<span class="input-group-text">팀 이름</span>
			</div>
			<select name="teamId" required="required">
				<option value="">선택</option>
				<c:forEach var="team" items="${teams}">
					<option value="${team.id}">${team.name}</option>
				</c:forEach>
			</select>
		</div>
		<div class="text-center">
			<input class="btn btn-outline-primary" type="submit" value="등록하기">
		</div>
	</form>
</div>
</body>


</html>