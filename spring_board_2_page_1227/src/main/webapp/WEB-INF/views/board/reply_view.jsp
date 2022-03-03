<%@ page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
  <table id="list-table" width="500" cellpadding="0" cellspacing="0" border="1">
      <form action="reply" method="post">
      <!-- input들 통해서 보냄 -->
         <input type="hidden" name="bid" value="${reply_view.bid}">
         <input type="hidden" name="bgroup" value="${reply_view.bgroup}">
         <input type="hidden" name="bstep" value="${reply_view.bstep}">
         <input type="hidden" name="bindent" value="${reply_view.bindent}">
         <tr>
            <td> 번호 </td>
            <td> ${reply_view.bid} </td>
         </tr>
         <tr>
            <td> 히트 </td>
            <td> ${reply_view.bhit} </td>
         </tr>
         <tr>
            <td> 이름 </td>
            <td> <input type="text" name="bname" value="${reply_view.bname}"></td>
         </tr>
         <tr>
            <td> 제목 </td>
            <td> <input type="text" name="btitle" value="${reply_view.btitle}"></td>
         </tr>
         <tr>
            <td> 내용 </td>
            <td> <textarea rows="10" name="bcontent" >${reply_view.bcontent}</textarea></td>
         </tr>
         <tr >
            <td colspan="2"> <input type="submit" value="답변"> &nbsp;&nbsp; <a href="list">목록</a></td>
         </tr>
      </form>
   </table>   
      

</body>
</html>