<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8");%>

<%@ page import="com.multi.dao.MDBoardDao" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>multi delete Page</title>
</head>
<body>
<%
	// getParameterValues : 여러개의 값을 가져올 수 있음
	String[] seq = request.getParameterValues("chk");

	MDBoardDao dao = new MDBoardDao();
	int res = dao.multiDelete(seq);
	
	if(res == seq.length){
%>
	<script type="text/javascript">
		alert("체크된 게시글을 삭제 성공하였습니다.");
		location.href="boardlist.jsp";
	</script>
<% 
	} else {
%>
	<script type="text/javascript">
		alert("체크된 게시글을 삭제 실패하였습니다.");
		location.href="boardlist.jsp";
	</script>
<%	
	}
%>


</body>
</html>