<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form>
<input type="checkbox" name="searchMajor" value="101">101
<input type="checkbox" name="searchMajor" value="101">102
<input type="checkbox" name="searchMajor" value="101">103
<input type="checkbox" name="searchMajor" value="101">201
<input type="checkbox" name="searchMajor" value="101">201
   <select name="searchGrade")>
      <option value="0">전체</option>
      <option value="1" ${param.searchGrade == 1 ? 'selected' : '' }>1학년</option>
      <option value="2" ${param.searchGrade == 2 ? 'selected' : '' }>2학년</option>
      <option value="3" ${param.searchGrade == 3 ? 'selected' : '' }>3학년</option>
      <option value="4" ${param.searchGrade == 4 ? 'selected' : '' }>4학년</option>
   </select>
   <select name="searchType">
      <option value="all" ${param.searchType == 'all' ? 'selected' : '' }>전체</option>
      <option value="id" ${param.searchType == 'all' ? 'selected' : '' }>아이디</option>
      <option value="name" ${param.searchType == 'all' ? 'selected' : '' }>이름</option>
   </select>
   <input type="text" name="searchWord" value="${param.searchWord }">
   <input type="submit" value="검색">
</form>
<c:forEach var="vo" items="${list}">
   <a href="view.do?studno=${vo.studno}">${vo.studno }</a> ${vo.name } ${vo.id } ${vo.grade } <br>
</c:forEach>
</body>
</html>