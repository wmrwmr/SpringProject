<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<sec:authentication property="principal" var="user"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<style>
#content table td {
	padding: 5px;
}

#content>table tr>td:nth-child(1) {
	width: 100px;
	text-align: center;
	background-color: #ddd;
}

#content>table td>img {
	height: 25px;
	border: 1px solid #aaa;
	border-radius: 50%;
	vertical-align: middle;
}

#content>table {
	border: 0;
	border-collapse: collapse;
	width: 900px;
}

#content>table td {
	padding: 10px;
}

#content>table tr {
	border-top: 1px solid #aaa;
	border-bottom: 1px solid #aaa;
}

#replyArea {
	width: 600px;
	margin-top: 20px;
}

div.reply {
	border: 1px solid #aaa;
	overflow: hidden;
	padding: 15px;
	margin-top: 5px;
}

div.reply>div.img {
	width: 50px;
	float: left;
}

div.reply>div.img>img {
	width: 40px;
	height: 40px;
	border: 1px solid #aaa;
	border-radius: 50%;
}

div.reply>div.content {
	width: 480 px;
	float: left;
}

div.reply>div.close {
	width: 30px;
	float: right;
}

div.reply>div.close>div {
	width: 25px;
	height: 25px;
	text-align: center;
	line-height: 20px;
	background-color: #aaa;
}

#replyWrite {
	width: 600px;
	margin-top: 20px;
}

#replyWrite>h4 {
	margin: 5px 0;
}

#replyWrite textarea {
	width: 100%;
	font-size: 120%;
	padding: 5px;
}

#replyWrite>form {
	text-align: right;
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

		<div
			class="d-flex align-items-center p-3 my-3 text-white bg-purple rounded shadow-sm">
			<h4>방명록 보기</h4>
		</div>

		<div class="my-3 p-3 bg-white rounded shadow-sm">
			<table class="table">
				<tr>
					<td>작성자</td>
					<td><img style="height: 30px;" class="border rounded-circle"
						src="${pageContext.request.contextPath}/uploadfile/${pageView.photo}">
						${pageView.username}</td>
				</tr>
				<tr>
					<td>작성일</td>
					<td>${pageView.regdate}</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${pageView.subject}</td>
				</tr>
				<tr>
					<td>내용</td>
					<td><pre style="line-height: 180%">${pageView.content}</pre></td>
				</tr>
			</table>
		</div>

		<div id="replyList" class="col-md-8 my-3 p-3 bg-white rounded shadow-sm">
			<h3 class="border-bottom border-gray pb-2 mb-0">댓글</h3>
			<c:if test="${not empty replyList}">
				<c:forEach items="${replyList}" var="reply">

					<div id="reply${reply.idx}" class="media text-muted pt-3">

						<img src="/op/uploadfile/${reply.photo}" style="height: 30px;"
							class="border rounded-circle mr-3">

						<p
							class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
							<strong class="d-block text-gray-dark">@${reply.userName}</strong>
							${reply.content}
						</p>

						<div onclick="deleteReply(${reply.idx})" class="badge  badge-info">X</div>
					</div>
				</c:forEach>
			</c:if>

		</div>

		<div class="col-md-8 my-3 p-3 bg-white rounded shadow-sm">
			<h5 class="border-bottom border-gray pb-2 mb-0">${user.member.username}</h5>

			<form id="replyWriteForm" class=" text-right">
				<!-- http://localhost:8080/op/guestbook/reply.do -->

				<textarea name="message" id="message" rows="5" cols="30"
					class="form-control p-3" required></textarea>
					
				<input type="hidden" name="memberIdx" value="${user.member.idx}">
				<input type="hidden" name="guestbookIdx" value="${pageView.idx}">
				
				<br> <input type="submit" value="작성" class="btn btn-primary">
			</form>

		</div>

		<div class="my-3 p-3 bg-white rounded shadow-sm mb-5">
			<a href="list" class="btn btn-success">목록</a>
			<c:if test="${loginInfo.idx eq pageView.memberidx}">
				<a href="edit?idx=${pageView.idx}"  class="btn btn-info">수정</a>
				<a href="javascript:deleteMessage(${pageView.idx})" class="btn btn-danger">삭제</a>
			</c:if>

		</div>


	</main>






	<!-- content 끝 -->

	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>


	<script>
		$(document).ready(function() {

			$('#replyWriteForm').submit(function() {
				
				console.log($(this).serializeArray());

				
				$.ajax({                 // http://localhost:8080/op/guestbook/view
					url : '${pageContext.request.contextPath}/api/v1/guestbook/reply', // http://localhost:8080/op/guestbook/reply/write
					type : 'POST',
					data : $(this).serialize(),
					success : function(data) {
						console.log(data); // idx 값
						
						var html = '';
						html += '<div id="reply'+data+'" class="media text-muted pt-3">';
						html += '<img src="/op/uploadfile/${loginInfo.photo}" style="height: 30px;" class="border rounded-circle mr-3">';
						html += '<p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">';
						html += '<strong class="d-block text-gray-dark">@${loginInfo.userName}</strong>';
						html += $('#message').val();
						html += '</p>';
						html += '<div onclick="deleteReply('+data+')" class="badge  badge-info">X</div>';
						html += '</div>';
						
						$('#replyList').append(html);
						$('#message').val('');
							
							
						
					},
					error : function() {
						console.log('통신에러 !!!!!');
					}
				});

				return false;
			});

		});
		
		
		
		function deleteReply(idx){
			
			if(confirm('댓글을 삭제하시겠습니까?')){
				
				//$('#reply'+idx).remove();
				
				
				$.ajax({
					//url : 'reply/delete', // http://localhost:8080/op/guestbook/reply/delete
					//                                    /op/api/v1/guestbook/reply/69
					url : '${pageContext.request.contextPath}/api/v1/guestbook/reply/'+idx,
					type : 'DELETE',
					//data : {idx : idx},
					success : function(data){
						if(data == '1'){
							// #reply4
							$('#reply'+idx).remove();
						}
					}
				});
			}
		}
		
		function deleteMessage(idx) {
			
			if(confirm('삭제하시겠습니까?')){
				location.href = 'delete.do?idx='+idx;
			}
		}
		
	</script>














</body>
</html>