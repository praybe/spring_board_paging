<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
<!-- "입력"을 누르면 write를 타게 되어있음 -->
		<form action="write" method="post">
			<tr>
				<td>이름 </td>
				<td> <input type="text" name="bname" size = "50"> </td>
			</tr>
			<tr>
				<td>제목 </td>
				<td> <input type="text" name="btitle" size = "50"> </td>
			</tr>
			<tr>
				<td>내용 </td>
				<td> <textarea name="bcontent" rows="10" ></textarea> </td>
			</tr>
			<tr >
			<!-- submit을 누르면 write로 가라 -->
				<td colspan="2"> <input type="submit" value="입력"> &nbsp;&nbsp; <a href="list">글작성</a></td>
			</tr>
		</form>
	</table>
   
</body>
</html>