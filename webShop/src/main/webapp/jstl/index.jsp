<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="test.Test"%>
<%@taglib prefix="c" uri=http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${name}
	<c:set var="id" value="lee" />
	${id }
	<br>
	<c:if test="${name eq 'lee' }">
	lee 입니다.
	</c:if>
	<c:if test="${name != 'lee' }">
	lee가 아닙니다.
	</c:if>
	<br>
	<c:if test="${!empty loginSession }">
	로그인중
	</c:if>
	<c:if test="${empty loginSession }">
	미로그인중
	</c:if>
	<br>
	<c:choose>
		<c:when test="${name == 'lee' }">이길동</c:when>
		<c:when test="${name == 'lee' }">이길동</c:when>
		<c:when test="${name == 'lee' }">이길동</c:when>
		<c:when test="${name == 'lee' }">이길동</c:when>
		<c:otherwise>기타</c:otherwise>
	</c:choose>
	<br>
	<c:forEach var="vo" items="${memberList }">
		${status.index } ${vo.id } ${vo.name }<br>
	</c:forEach>
	<br>
	<img src="<c:url value="/pro14/img/rose.PNG"/>">
	<br>
	<!-- 경로를 정확하게 써 줘야 함. 서버에서는 c:url을 안씀 -->
	<fmt:formatNumber value="${price }" />
	<br>
	<fmt:formatDate value="${today }" pattern="YY-MM-dd HH:mm:ss" /><br>
	${test.sum(1,2) }
	<br>
	${Test.differ(2,1) }
</body>
</html>