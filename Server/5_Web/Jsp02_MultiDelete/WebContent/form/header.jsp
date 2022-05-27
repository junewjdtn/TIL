<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header Page</title>
<style>
	header {
		background-color:skyblue;
		height: 50px;
	}
	
	a{text-decoration: none;}
</style>
</head>
<body>
	<header><a href="./boardlist.jsp">게시판 구현하기</a></header>
</body>
</html>