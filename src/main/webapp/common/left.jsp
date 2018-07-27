<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="/newPostServlet?postSelect=${postSelect}">게시판 생성</a></li>
		<li class="active"><a href="/boardServlet?page=1&pageSize=10&postSelect=${postSelect}">자유게시판</a></li>
		<c:forEach items="${postList}" var="list">
			<li class="active"><a href="/newPostServlet?page=1&pageSize=10&postSelect=${list.postList_num}&postList_num=${postList_num}">${list.postName}</a></li>
		</c:forEach>
	</ul>
</div>