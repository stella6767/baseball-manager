<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

	<nav class="navbar navbar-expand-md bg-dark navbar-dark">
		<a class="navbar-brand" href="/">관리자</a>
		<!-- Links -->
		<ul class="navbar-nav w-100">
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link " href="/fieldAdd">야구장 등록</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="/teamAdd">팀 등록</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="/playerAdd">선수 등록</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="#">퇴출선수 등록</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="/field">야구장 관리</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="/team">팀 관리</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="/player">선수 관리</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="/position">포지션별 선수</a>
			</li>
			<li class="nav-item text-center" style="width: 10%;">
				<a class="nav-link" href="#">팀별 선수</a>
			</li>
		</ul>

	</nav>
	<br>