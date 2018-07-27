<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

<title>게시글 상세보기</title>

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

	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" class="form-horizontal" role="form"
					action="/boardUpdate" method="get">
					<input type="hidden" id="num" name="num" value="${boardVo.board_num}">
						
					<div class="form-group">
						<label for="board_num" class="col-sm-2 control-label">게시글 번호</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVo.board_num}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="board_title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVo.board_title}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="board_content" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<label class="control-label">${boardVo.board_content}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="board_filename" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<img src="/pic?id=${boardVo.board_num}">
						</div>
						<input type="file" value="첨부파일 추가">
						<button type="submit" class="btn btn-default">수정</button>
					</div>
				</form>
			</div>
			
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action="/boardDelete" class="form-horizontal" role="form"
					method="post">
					<div class="form-group">
						<input type="hidden" id="num" name="num"
							value="${boardVo.board_num}">
						<button type="submit" class="btn btn-default">삭제</button>
					</div>
				</form>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form action="/boardReply" class="form-horizontal" role="form"
					method="post">
					<div class="form-group">
						<input type="hidden" id="num" name="num"
							value="${boardVo.board_num}">
						<button type="submit" class="btn btn-default">답글</button>
					</div>
				</form>
			</div>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="form-group">
					<label for="board_asComment" class="col-sm-2 control-label">댓글</label>
					<div class="col-sm-10">
						<label class="control-label"></label>
					</div>
					<input type="text" id="comment" name="comment"> <input
						type="button" id="commentSave" name="commentSave" value="댓글저장">
				</div>
			</div>
		</div>
	</div>
</body>
</html>
