<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<title>페이징</title>
</head>
<body>
	<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호:</td>
			<td>이름:</td>
			<td>제목:</td>
			<td>날짜:</td>
			<td>히트:</td>

		</tr>


		<!-- 여기 또 핵심 3 -->
		<c:forEach var="board" items="${boardList}">
			<tr>

				<td>${board.bid}</td>
				<td>${board.bname}</td>
				<td><c:forEach begin="1" end="${board.bindent}">-</c:forEach> <a
					href="content_view?bid=${board.bid}">${board.btitle}</a></td>


				<td>${board.bdate}</td>
				<td>${board.bhit}</td>

			</tr>
		</c:forEach>

		<tr>
			<td colspan="5"><a href="write_view">글작성</a></td>
		</tr>
	</table>
	
	
	
<!-- pageMaker란 Controller에 있는 pageMaker 객체. 그 객체가 다 가지고 있으니.. -->
<!-- makeQuery란 pageVO에 있는 함수-->
<!--?pageNum=1&amount=10  부터   ?pageNum=401&amount=10-->
	<c:if test="${pageMaker.pre}">
		<a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
	</c:if>

	<!-- 링크를 걸어준다 1-10페이지까지 페이지를 만들어주는것  -->
	<c:forEach var="idx" begin="${pageMaker.startPage }"
		end="${pageMaker.endPage }">
		<a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
	</c:forEach>

	<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
		<a href="list2${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
	</c:if>
	<br>





</body>
</html>