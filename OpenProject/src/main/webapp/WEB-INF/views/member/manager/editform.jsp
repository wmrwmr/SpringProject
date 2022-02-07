<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 수정</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>
#oldfile {
	height: 100px;
}
</style>


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
			<h3>회원 가입</h3>
			<hr>
			<!-- form 경로와 처리 경로가 동일 -> method 로 구분 -->
			<!-- action="reg.do" 생략 가능 -->
			<form method="post" enctype="multipart/form-data">

				<div class="form-group row">
					<label for="userid" class="col-sm-2 col-form-label">아이디</label>
					<div class="col-sm-10">
						<input type="hidden" name="idx" value="${member.idx}"> <input
							type="email" name="userid" id="userid" value="${member.userid}"
							class="form-control" readonly>
					</div>
				</div>

				<div class="form-group row">
					<label for="pw" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="pw" id="pw"
							value="${member.password}" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="repw" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="repw" id="repw"
							value="${member.password}" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-10">
						<input type="text" name="username" id="username"
							value="${member.username}" class="form-control" required>
					</div>
				</div>

				<div class="form-group row">
					<label for="photo" class="col-sm-2 col-form-label">현재 사진</label>
					<div class="col-sm-10">
						<c:if test="${not empty member.photo}">
							<img id="oldfile"
								src="${pageContext.request.contextPath}/uploadfile/${member.photo}">
							<br>
						</c:if>

						<input type="hidden" name="oldfile" value="${member.photo}">

					</div>
				</div>

				<div class="form-group row">
					<label for="photo" class="col-sm-2 col-form-label">사진</label>
					<div class="col-sm-10">
						<input type="file" name="photo" id="photo"
							class="form-control-plaintext">
					</div>
				</div>

				<input type="submit" value="정보수정" class="btn  btn-primary">
				<input type="reset" class="btn btn-secondary">


			</form>
		</div>

	</main>


	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>