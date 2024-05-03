<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>a.jsp</h1>
	<%
	request.setAttribute("email", "hong@gmail.com");
	response.sendRedirect("b.jsp");
	%>
	<!-- jsp에서 forward를 쓸 일은 없음 -->
	<jsp:forward page="b.jsp"></jsp:forward>
</body>
</html>