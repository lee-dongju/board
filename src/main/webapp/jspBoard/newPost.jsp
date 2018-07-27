<%@page import="org.w3c.dom.ls.LSInput"%>
<%@page import="kr.or.ddit.board.model.BoardVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>



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

</head>
<body>
	<%@include file="/common/top.jsp"%>

	<!-- 	<form id="frm" action="/studentDetail" method="get"> -->
	<!-- 		<input type="hidden" name="id" id="id"> -->
	<!-- 	</form> -->

	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<div class="table-responsive">
							<form action="/newPostServlet" method="post">
								<input type="hidden" id="list" value="${postList}">
								게시판 이름 <input type="text" id="name" name="name"> 
								<select	name="postSelect" id="postSelect">
									<option value="y">사용</option>
									<option value="n">미사용</option>
								</select> 
								<input type="submit" value="생성"> 
								<br><br>
								
							</form>
							<form action="/newPostServlet" method="get">
								<tbody>
									<c:forEach items="${postList}" var="list">
										<tr>
											<label>게시판 이름</label>
											<input type="hidden" id="postList_num" name="postList_num" value="${list.postList_num}"/>
											<input type="text" id="postName" name="postName" value="${list.postName}"/>
											<select id="postSelect" name="postSelect">
												<option value="y">사용</option>
												<option value="n">미사용</option>
											</select>
											<button>수정</button>
											<br>
										</tr>
									</c:forEach>
								</tbody>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
