<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${result eq '1'}">
<script>
	alert('수정되었습니다.');
	location.href = 'view.do?idx=${param.guestbookIdx}';
</script>
</c:if>

<c:if test="${result ne '1'}">
<script>
	alert('문제가 발생했습니다. 다시 시도해주세요.');
	history.go(-1);
</script>
</c:if>