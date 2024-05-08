<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#btn").click(function() {
			//alert(1);
			if ($("#searchValue").val() == '') {
				alert('검색어를 입력하세요');
				$("$searchValue").focus();
				return;
			}
		})
	});
</script>
</head>
<body>
	<input type="text" id="searchValue">
	<input type="button" id="btn" value="도서 검색">
	<div id="bookArea"></div>
</body>
</html>