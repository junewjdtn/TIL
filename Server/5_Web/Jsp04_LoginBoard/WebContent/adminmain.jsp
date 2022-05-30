<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@page import="com.login.dto.MyMemberDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AdminMain Page</title>
<style>
	a{text-decoration: none;}
</style>
</head>
<body>
<%
	MyMemberDto dto = (MyMemberDto)session.getAttribute("dto");

	/* 로그인이 제대로 되어 있지 않을 경우 */
	if(dto == null){
		pageContext.forward("index.jsp");
	}
%>
	<div>
		<span><%=dto.getMyid() %>님 환영합니다. (등급 : <%=dto.getMyrole() %>)</span>&nbsp;
		<a href="logincontroller.jsp?command=logout" style="color: lightgray;">로그아웃</a>
	</div>
	
	<div>
		<div>
			<a href="logincontroller.jsp?command=userlistall" style="color: blue;">회원 정보 조회(All)</a>
		</div>
	</div>


</body>
</html>