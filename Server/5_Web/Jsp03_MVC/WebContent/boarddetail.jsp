<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import="com.mvc.dto.MVCBoardDto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BoardDetail Page</title>
</head>
<body>
<%
	MVCBoardDto dto = (MVCBoardDto)request.getAttribute("oneList");
%>
	<h1>게시글 보기</h1>
	<table border="1">
		<tr>
			<th>NO</th>
			<td><%=dto.getSeq() %></td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td><%=dto.getWriter() %></td>
		</tr>
		<tr>
			<th>DATE</th>
			<td><%=dto.getRegdate() %></td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td><%=dto.getTitle() %></td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td><textarea rows="10" cols="60" readonly="readonly"><%=dto.getContent() %></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='mycontroller.jsp?command=boardupdateform&seq=<%=dto.getSeq() %>'">
				<input type="button" value="삭제" onclick="location.href='mycontroller.jsp?command=boarddelete&seq=<%=dto.getSeq() %>'">
				<input type="button" value="목록" onclick="location.href='mycontroller.jsp?command=boardlist'">
			</td>
		</tr>
	</table>
</body>
</html>