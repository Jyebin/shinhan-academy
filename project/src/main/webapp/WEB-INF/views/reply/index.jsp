<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
<META name="viewport"
	content="width=device-width, height=device-height, initial-scale=1.0, user-scalable=no">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
<link rel="stylesheet" href="/css/contents.css" />
<link rel="stylesheet" href="/css/reset.css" />
<link rel="stylesheet" href="/css/style.css" />
<script src="/js/script.js"></script>
<script src="/js/main.js"></script>
</head>
<body>

	<div class="wrap">
		<%@ include file="/WEB-INF/views/include/header.jsp"%>
		<div class="sub">
			<div class="size">
				<h3 class="sub_title">게시판</h3>

				<div class="bbs">
					<table class="list">
						<p>
							<span><strong>총 ${map.total}개</strong> | ${replyVO.page }/${map.totalPage }페이지</span>
						</p>
						<caption>게시판 목록</caption>
						<colgroup>
							<col width="80px" />
							<col width="*" />
							<col width="100px" />
							<col width="100px" />
						</colgroup>
						<thead>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<c:if test="${empty map.list }">
								<tr>
									<td class="first" colspan="8">등록된 글이 없습니다.</td>
								</tr>
							</c:if>
							<c:forEach var="vo" items="${map.list }">
								<tr>
									<td>${vo.no }</td>
									<td class="txt_l" style="text-align: left;"><c:forEach
											begin="1" end="${vo.nested }">
                                      &nbsp;
                                   </c:forEach> <c:if test="${vo.nested > 0}">
											<img src="/img/ico_re.png">
										</c:if> <a href="detail.do?no=${vo.no}">${vo.title }</a></td>
									<td class="writer">홍길동</td>
									<td class="date"><fmt:formatDate value="${vo.regdate }"
											pattern="YYYY-MM-dd" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					<div class="btnSet" style="text-align: right;">
						<a class="btn" href="board_write.html">글작성 </a>
					</div>
					<div class="pagenate clear">
						<ul class='paging'>
							<c:if test="${map.isPrev }">
								<!-- 이전 페이지가 있으면 -->
								<li><a href='index.do?page=${map.startPage-1 }'><</a></li>
							</c:if>
							<c:forEach var="p" begin="${map.startPage }"
								end="${map.endPage }">
								<c:if test="${replyVO.page == p }">
									<li><a href='javascript:;' class='current'>${p }</a></li>
								</c:if>
								<c:if test="${replyVO.page != p }">
									<li><a href='index.do?page=${p }'>${p }</a></li>
									<!-- 클릭해도 아무 일이 없어야 함. 현재 페이지이기 때문. -->
								</c:if>
							</c:forEach>
							<c:if test="${map.isNext }">
								<li><a href='index.do?page=${map.endPage+1 }'>></a></li>
							</c:if>
						</ul>
					</div>

					<!-- 페이지처리 -->
					<div class="bbsSearch">
						<form method="get" name="searchForm" id="searchForm" action="">
							<span class="srchSelect"> <select id="stype"
								name="searchType" class="dSelect" title="검색분류 선택">
									<option value="all">전체</option>
									<option value="title"
										<c:if test="${param.searchType=='title' }">selected</c:if>>제목</option>
									<option value="contents"
										<c:if test="${param.searchType=='content' }">selected</c:if>>내용</option>
							</select>
							</span> <span class="searchWord"> <input type="text" id="sval"
								name="searchWord" value="" title="검색어 입력"> <input
								type="button" id="" value="검색" title="검색">
							</span>
						</form>

					</div>
				</div>
			</div>
		</div>
		<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	</div>
</body>
</html>