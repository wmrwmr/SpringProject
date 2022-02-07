<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<style>

#msg {
	display: none;
}

.text_red {
	color: red;
}

.text_blue {
	color: blue;
}
</style>
<script>
	$(document).ready(function() {

		$('#userid').focusin(function() {
			$('#msg').css('display', 'none');
			$('#msg').removeClass('text_blue');
			$('#msg').removeClass('text_red');
			$('#msg').text('');
		});

		$('#userid').focusout(function() {

			$.ajax({             // http://localhost:8080/op/member/reg
				url : 'checkid', // http://localhost:8080/op/member/checkid
				type : 'get',
				data : {
					userid : $('#userid').val()
				},
				success : function(data) {
					
					console.log('통신 결과 : ', data);
					
					// Y | N
					if (data == 'Y') {
						// 사용 가능한 아이디
						$('#msg').css('display', 'block');
						$('#msg').text('멋진 아이디 입니다!');
						$('#msg').addClass('text_blue');

					} else {
						// 사용 불가능한 아이디
						$('#msg').css('display', 'block');
						$('#msg').text('사용중이거나 탈퇴한 아이디 입니다!');
						$('#msg').addClass('text_red');
					}
				},
				error : function() {
					console.log('비동기 통신 오류');
				}
			});

		});

		$('#ajaxBtn').click(function() {

			// 비동기 통신을 이용해서 파일을 업로드 하는 경우
			// FormData 를 이용
			// 파라미터 이름과 전송할 데이터를 설정

			var photoFile = $('#photo');
			var file = photoFile[0].files[0];

			var formData = new FormData();
			formData.append('userid', $('#userid').val());
			formData.append('pw', $('#pw').val());
			formData.append('username', $('#username').val());
			formData.append('photo', file);

			$.ajax({
				url : 'reg2.do',
				type : 'POST',
				data : formData,
				enctype : 'multipart/form-data',
				processData : false,
				contentType : false,
				cash : false,
				success : function(data) {
					if (data == '1') {
						alert('회원가입 성공!');
						location.href = 'login.do';
					} else {
						alert('회원가입 실패!');
						history.go(-1);
					}
				},
				error : function(req) {
					console.log(req);
				}
			});

		});

	});
</script>


</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->



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
						<input type="email" name="userid" id="userid" class="form-control" required>
						<div id="msg"></div>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="pw" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="pw" id="pw"  class="form-control" required>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="repw" class="col-sm-2 col-form-label">비밀번호</label>
					<div class="col-sm-10">
						<input type="password" name="repw" id="repw"  class="form-control" required>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="username" class="col-sm-2 col-form-label">이름</label>
					<div class="col-sm-10">
						<input type="text" name="username" id="username"  class="form-control" required>
					</div>
				</div>
				
				<div class="form-group row">
					<label for="photo" class="col-sm-2 col-form-label">사진</label>
					<div class="col-sm-10">
						<input type="file" name="photo" id="photo" class="form-control-plaintext">
					</div>
				</div>
				
				<input type="submit" value="회원가입" class="btn  btn-primary"> 
				<input type="reset" class="btn btn-secondary"> 
				<input type="button" value="ajax로 회원가입" id="ajaxBtn" class="btn btn-success">

			</form>
		</div>

	</main>

	<!-- content 시작 -->
	<div id="content"></div>
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

</body>
</html>