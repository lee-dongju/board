<%@page import="org.w3c.dom.ls.LSInput"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

<script>
	$(function(){
		$("table tbody tr").on("click", function(){
			//tr태그의 data-id 속성값을 읽어서 input 태그의 id값으로 설정
			//form태그를 submit
			$("#id").val($(this).data("id"));
			$("#frm").submit();
		});
	});
</script>

</head>

<body>


	<%@include file="/common/top.jsp"%>

	<form id="frm" action="/boardDetail" method="get">
		<input type="hidden" name="id" id="id">
	</form>
	
	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">자유게시판</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<thead>
									<tr>
										<th>게시글 번호</th>
										<th>제목</th>
										<th>작성자 아이디</th>
										<th>작성일시</th>
									</tr>
								</thead>
									<tbody>
										<c:forEach items="${boardList}" var="board">
										<%-- 태그 클릭시 상세 페이지로 이동 --%>
											<tr data-id="${board.board_num }">
												<td>${board.board_num }</td>
												<td>${board.board_title }</td>
												<td>${board.std_id }</td>
												<td><fmt:formatDate value="${board.board_reg }" pattern="yyyy-MM-dd"/></td>
											</tr>
										</c:forEach>
									</tbody>
							</table>
						</div>

						<a href="/newBoard" class="btn btn-default pull-right" id="newBoard">게시글 생성
							<input type="hidden" id="std_id" value="${sv.std_id}">
						</a>

						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi") %>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
