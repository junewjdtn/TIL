<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
%>
	<h1>res PAGE</h1>
	<h1><%=request.getParameter("tname") %> 님의 주소는 <%=request.getParameter("taddr") %> 입니다.</h1>
	
<pre>
form의 method=get 방식  : queryString 포함 		(엽서)
form의 method=post 방식 : 주소줄에 요청 페이지만 있다.	(우편)

queryString : ?를 포함한 변수=값&변수=값&... 형식으로 구성되어 있음

script type = "text/javascript"
   function test(){
      alert("test!!!");
   }
script

input type="button" onclick="test();" value="버튼"
</pre>
</body>
</html>