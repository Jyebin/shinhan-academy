<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
event.jsp
<c:if test="${not empty login }">
${login.name }님 안녕하세요
</c:if>
<c:if test="${empty login }">
<a href="login.do">로그인</a>
</body>
</html>