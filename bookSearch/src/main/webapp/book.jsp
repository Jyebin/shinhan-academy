<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function(){
		$("#btn").click(function() {
			//alert(1);
			if ($("#searchValue").val() == '') {
				alert('검색어를 입력하세요');
				$("#searchValue").focus();
				return;
			}
			$.ajax({
				url : '/bookSearch/book/list.do',
				data : {
					searchWord:$("#searchValue").val()
				},
				dataType : 'json',
				success : function(res) {
					console.log(res.items);
					var html = "<table border='1'>";
					html += "<tr>";
					html += "	<th>이미지</th>";
					html += "	<th>제목</th>";
					html += "	<th>저자</th>";
					html += "</tr>";
					res.items.forEach(item=>{
						console.log(item);
						html += "<tr>";
						html += "	<td><a href='"+item.link+"' target='_blank'><img width='100' src='"+item.image+"'></a></td>";
						html += "	<td>"+item.title+"</td>";
						html += "	<td>"+item.author+"</td>";
						html += "</tr>";
					});
					html += "</table>";
					$("#bookArea").html(html);
				}
			});
		});
	});
</script>
</head>
<body>
<input type="text" id="searchValue">
<input type="button" id="btn" value="도서 검색">
<div id="bookArea"></div>
</body>
</html>