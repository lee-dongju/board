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

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/common.css" rel="stylesheet">

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
$(function(){
	
});
</script>
</head>

<body>
	<%@include file="/common/top.jsp"%>
	
	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<form id="frm" action="/newBoard" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
					<input type="hidden" id="std_id" name="std_id" value="${sv.std_id}">
					<div class="form-group">
						<label for="board_title" class="col-sm-2 control-label">글제목</label>
						<div class="col-sm-10">
							<input type="text" id="board_title" name="board_title" value="제목입니다.">
						</div>
					</div>
					
					<div class="form-group">
						<label for="board_title" class="col-sm-2 control-label">글내용</label>
						<div class="col-sm-10">
							<input type="text" id="board_content" name="board_content" value="글내용 입니다.">
						</div>
					</div>

					<div class="form-group">
						<label for="board_file" class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-10">
							<input type="text" id="board_file" name="board_file">
							
						</div>
					</div>
					
					<input type="hidden" id="board_filename" name="board_filename" value="${board_filename}">
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="addFile" type="button" class="btn btn-default">파일추가</button>
						</div>
					</div>
					
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="insertBtn" type="submit" class="btn btn-default">저장</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
