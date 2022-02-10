<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">공지사항 수정/삭제</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->


<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				&nbsp;
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">

				<form role="form" action="/bangbang/board/modify" method="post">
				
				<input type='hidden' name='pageNum' value='<c:out value="${cri.pageNum }"/>'>
				<input type='hidden' name='amount' value='<c:out value="${cri.amount }"/>'>
				


					<div class="form-group">
						<label>공지사항 번호</label> <input class="form-control" name='nidx'
							value='<c:out value="${board.nidx}"/>' readonly='readonly'>

					</div>

					<div class="form-group">
						<label>제목</label> <input class="form-control" name='title'
							value='<c:out value="${board.title }"/>'>
					</div>

					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="3" name='content'> <c:out
								value="${board.content }" /> </textarea>
					</div>


					<div class="form-group">
						<label>등록일</label> <input class="form-control" name='regDate'
							value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate }"/>'
							readonly='readonly'>
					</div>

					<div class="form-group">
						<label>수정일</label> <input class="form-control"
							name='updateDate'
							value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.updatedate }"/>'
							readonly='readonly'>
					</div>


					<button type="submit" data-oper='modify' class="btn btn-default">수정</button>
					<button type="submit" data-oper='remove' class="btn btn-default">삭제</button>
					<button type="submit" data-oper='list' class="btn btn-info">목록</button>

				</form>
			</div>
		</div>
	</div>
</div>


<%@include file="../includes/footer.jsp"%>

<script type="text/javascript">
	$(document).ready(function() {

		var formObj = $("form");

		$('button').on("click", function(e) {

			e.preventDefault();

			var operation = $(this).data("oper");
			
			console.log(operation);

			if (operation === 'remove') {
				formObj.attr("action", "/bangbang/board/remove");
			} else if (operation === 'list') {
				//move to list
				formObj.attr("action", "/bangbang/board/list").attr("method", "get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone();
				
				formObj.empty();
				
				formObj.append(pageNumTag);
				formObj.append(amountTag);
			}
			formObj.submit();

		});

	});
</script>