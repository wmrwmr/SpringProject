<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/signin.css">




</head>
<body>

	<!-- 해더 시작 -->
	<%@ include file="/WEB-INF/views/frame/header.jsp"%>
	<!-- 해더 끝 -->

	<!-- 네비게이션 시작 -->
	<%@ include file="/WEB-INF/views/frame/nav.jsp"%>
	<!-- 네비게이션 끝 -->






<!-- <form class="form-signin" method="post"> -->
<!--  Spring Security 이용한 로그인 처리 -->
<form class="form-signin" action="${pageContext.request.contextPath}/login" method="post">
  <input type="hidden" name="url" value="${param.referer}">
  <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
  
  <label for="inputEmail" class="sr-only">Email address</label>
  
  <%-- <input type="text" id="inputEmail"  name="userid" value="${cookie.saveId != null ? cookie.saveId.value : ''}"
  class="form-control" placeholder="Email address" required autofocus> --%>
  
  <!--  Spring Security 이용한 로그인 처리 -->
  <input type="text" id="inputEmail"  name="username" value="${cookie.saveId != null ? cookie.saveId.value : ''}"
  class="form-control" placeholder="Email address" required autofocus>
  
  <label for="inputPassword" class="sr-only">Password</label>
  <!-- <input type="password" id="inputPassword" name="pw" class="form-control" placeholder="Password" required> -->
  <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
  <div class="checkbox mb-3">
    <label>
      <input type="checkbox"  name="saveid" value="on" ${cookie.saveId != null ? 'checked' : ''}> Remember EMAIL
    </label>
  </div>
  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
  
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
  
</form>





	<!-- content 시작 -->
	
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp" %>

</body>
</html>