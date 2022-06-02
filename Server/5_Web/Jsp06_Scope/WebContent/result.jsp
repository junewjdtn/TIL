<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result Page</title>
</head>
<body>
	<h1>result</h1>
	PageId : <%=pageContext.getAttribute("pageId") %><br>
	RequestId : <%=request.getAttribute("reqId") %><br>
	SessionId : <%=session.getAttribute("sessionId") %><br>
	ApplicationId : <%=application.getAttribute("appId") %><br>
	
</body>
</html>