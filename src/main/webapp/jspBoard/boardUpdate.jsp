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
	$("#updateBtn").on("click", function(){
		if($("#title").val().length == 0){
			alert("제목을 입력하세요.");
			$("#title").focus();
			return false;
		}
		
		if($("#content").val().length == 0){
			alert("내용을 입력하세요");
			$("#content").focus();
			return false;
		}
		
		alert($("#board_num").val());
		
		//여기까지 진행되면 validation 통과 -> submit
		console.log($("#frm").serialize());
		$("#frm").submit();
	});
});
</script>
</head>

<body>
	<%@include file="/common/top.jsp"%>
	
	<div class="container-fluid">
		<div class="row">

			<%@include file="/common/left.jsp"%>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			
			
				<form id="frm" action="/boardUpdate" method="post" class="form-horizontal" role="form" enctype="multipart/form-data">
					<div class="form-group">
						<label for="board_num" class="col-sm-2 control-label">게시글 번호</label>
						<div class="col-sm-10">
							<input type="hidden" class="form-control" id="board_num" name="board_num"
								value="${boardVo.board_num}">
							<label class="control-label">${boardVo.board_num}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="title" class="col-sm-2 control-label">제목</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="title" name="title"
								value="${boardVo.board_title}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="content"  class="col-sm-2 control-label">내용</label>
						<div class="col-sm-6">
							<input type="text" id="content" class="form-control" name="content"
								value="${boardVo.board_content}">
						</div>
					</div>
					
					<div class="form-group">
						<label for="file"  class="col-sm-2 control-label">첨부파일</label>
						<div class="col-sm-6">
							<img src="/pic?id=${boardVo.std_id}">
							<input type="file" name="pic">
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button id="updateBtn" type="button" class="btn btn-default">수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
