<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.my.dao.MyBoardDao" %>
<%@ page import="com.my.dto.MyBoardDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>selectone.jsp</title>
</head>
<body>
<%
	/* myno의 값을 가져 옴 (무조건 String 타입으로 넘어옴)*/
	/* Integer.parseInt를 사용하여 타입을 바꾸어 줌 */
	int myno = Integer.parseInt(request.getParameter("myno"));
	MyBoardDao dao = new MyBoardDao();
	MyBoardDto dto = dao.selectOne(myno);
%>

	<table>
		<tr>
			<th>NAME</th>
			<td><%=dto.getMyname() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=dto.getMytitle() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>
				<textarea rows="10" cols="60" readonly="readonly"><%=dto.getMycontent() %></textarea>
			</td>
		</tr>
		<tr>
			<td colspan=2>
				<button onclick="">수정</button>&nbsp;&nbsp;
				<button onclick="">삭제</button>&nbsp;&nbsp;
				<button onclick="">목록</button>&nbsp;&nbsp;
			</td>
		</tr>
	
	</table>

</body>
</html>