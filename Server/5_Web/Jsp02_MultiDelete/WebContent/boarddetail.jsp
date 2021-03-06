<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import="com.multi.dao.MDBoardDao"%>
<%@page import="com.multi.dto.MDBoardDto"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board detail Page</title>
</head>
<body>
<%
	int seq = Integer.parseInt(request.getParameter("seq"));

	MDBoardDao dao = new MDBoardDao();
	MDBoardDto dto = dao.selectOne(seq);
%>
<%@ include file="./form/header.jsp" %>

	<div id="detailform">
		<h1>게시글 보기</h1>
		<table border="1">
			<tr>
				<th>NO</th>
				<td><%=dto.getSeq() %></td>
			</tr>
			<tr>
				<th>WRITER</th>
				<td><%=dto.getTitle() %>
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
				<td colspan="2"; align="right";>
					<input type="button" value="수정">
					<input type="button" value="삭제">
					<input type="button" value="목록" onclick="location.href='boardlist.jsp'">
				</td>
			</tr>
		</table>
	</div>

<%@ include file="./form/footer.jsp" %>
</body>
</html>