<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>


</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->

	<!-- content 시작 -->
	
	<main role="main" class="container">

		<div class="my-3 p-3 bg-white rounded shadow-sm ">
		
		<h3>회원 정보</h3>
		<hr>
			<table class="table">
				<tr>
					<td>아이디</td>
					<td> ${member.userid} </td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td> ${member.password}</td>
				</tr>
				<tr>
					<td>이름</td>
					<td> ${member.username}</td>
				</tr>
				<tr>
					<td>사진</td>
					<td>
						<img src="${pageContext.request.contextPath}/uploadfile/${member.photo}" height="100">
					</td>
				</tr>
				<tr>
					<td>가입일</td>
					<td> ${member.regdate}</td>
				</tr>		
			</table>
		
		
		</div>
		
	</main>
	
	
	
	
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

</body>
</html>
