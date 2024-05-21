<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	event.jsp
	<c:if test="${not empty login}">
    ${login.name}님 안녕하세요 <a href="mypage.do">마이페이지</a>
		<img src="/test/upload/&filename_real${login.filename_real }&filename_org=${URLEncoder.encode(login.filename_org)}">${login.filename_org }</a>
    다운로드 : <a href="/test/download.do?">${login.filename_org }</a>
	</c:if>
	<c:if test="${empty login}">
		<a href="login.do">로그인</a>
	</c:if>
</body>
</html>