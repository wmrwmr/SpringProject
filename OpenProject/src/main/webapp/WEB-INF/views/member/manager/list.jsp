<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 리스트</title>

<%@ include file="/WEB-INF/views/frame/pageset.jsp"%>

<!-- <style>

#content>div {
	padding: 15px;
}

#content>table {
	border: 0;
	border-collapse: collapse;
	
	width: 900px;
}
#content>table td, #content>table th {
	border: 1px solid #aaa;
	padding: 10px;
	
	text-align: center;
}

#listInfo {
	border : 1px solid #aaa;
	width : 870px;
}

#paging {
	overflow: hidden;
}

#paging>a {
	display: block;
	
	width: 30px;
	height: 30px;
	
	border: 1px solid #aaa;
	
	text-align: center;
	line-height: 30px;
	
	float : left;
	
	margin-right: 5px;
	
	text-decoration: none;
}

#paging>a:hover {
	background-color: #ff0;
	color: #00f;
}

.curpage {
	background-color: #333;
	color: #fff;
}

</style> -->
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
			<h4>회원 리스트</h4>
		</div>

		<div class="my-3 p-3 bg-white rounded shadow-sm">

			<form>
				<div class="form-row">
					<div class="col-auto">
						<select name="searchType" class="form-control">
							<option value="uid"
								${param.searchType eq 'uid' ? 'selected' : ''}>아이디</option>
							<option value="uname"
								${param.searchType eq 'uname' ? 'selected' : ''}>이름</option>
							<option value="both"
								${param.searchType eq 'both' ? 'selected' : ''}>아이디 +
								이름</option>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" name="keyword" class="form-control"
							value="${param.keyword}">
					</div>
					<div class="col-auto">
						<input type="submit" value="검색" class="btn btn-primary">
					</div>
				</div>
			</form>

			<div class="border mt-3 p-2">전체 회원 수: ${listView.totalCount}명 ,
				현재 페이지: ${listView.currentPage}/${listView.pageTotalCount}</div>

			<table class="table table-striped table-hover">
				<thead class="thead-dark">
					<tr>
						<th>idx</th>
						<th>user ID</th>
						<th>password</th>
						<th>user Name</th>
						<th>photo</th>
						<th>regdate</th>
						<th>manage</th>
					</tr>
				</thead>

				<c:if test="${empty listView.list}">\
			<tr>
						<td colspan="7">등록된 회원 데이터가 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty listView.list}">

					<c:forEach items="${listView.list}" var="member">
						<tr>
							<td>${member.idx}</td>
							<td>${member.userid}</td>
							<td>${member.password}</td>
							<td>${member.username}</td>
							<td>${member.photo}</td>
							<td>${member.regdate}</td>
							<td><a href="edit?idx=${member.idx}">수정</a> <a
								href="javascript:delMember(${member.idx})">삭제</a></td>
						</tr>
					</c:forEach>

				</c:if>


			</table>

			<div class="btn-toolbar" role="toolbar" >
				<div class="btn-group mr-2" role="group">
				
					<c:if test="${listView.pageTotalCount > 0}">
		
						<c:forEach begin="1" end="${listView.pageTotalCount}" var="pnum">
							<a
								href="list.do?p=${pnum}&searchType=${param.searchType}&keyword=${param.keyword}"
								class="btn ${listView.currentPage eq pnum ? 'btn-dark': 'btn-white'}">${pnum}</a>
						</c:forEach>
		
					</c:if>
				
					
				</div>
				
			</div>



		</div>


	</main>




	
	
	<!-- content 끝 -->


	<!-- Javascript 추가 -->
	<%@ include file="/WEB-INF/views/frame/footerset.jsp"%>

	<script>
		function delMember(idx) {

			if (confirm("해당 회원 정보를 삭제하시겠습니까?")) {
				location.href = 'delete?idx=' + idx;
				// http://localhost:8080/op/member/list
			}

		}
	</script>

</body>
</html>








