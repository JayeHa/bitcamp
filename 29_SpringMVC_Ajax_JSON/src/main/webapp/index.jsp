<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작화면</title>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	function getJsonData() {
		alert("getJsonData() 시작~");
		
	}
</script>
</head>
<body>
<div id="container">
	<h1>게시판 프로그램</h1>
	<hr>
	<p><a href="login.do">로그인 페이지로 이동(GET)</a></p>
	<hr><hr>
	<p><a href="javascript:getJsonData()">JSON 데이터 받아서 화면 표시</a></p>
</div>
<hr>
<div id="listDisp">
	<ul>
		<li>데이터 가져와서 출력하기</li>
	</ul>
</div>

</body>
</html>





