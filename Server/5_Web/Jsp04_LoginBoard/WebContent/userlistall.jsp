<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
    
<%@page import="com.login.dto.MyMemberDto"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserListAll Page</title>
<script type="text/javascript">
	function updateRole(myno){
		location.href="logincontroller.jsp?command=updateroleform&myno="+myno;
	}
</script>
</head>
<body>
<%
	List<MyMemberDto> list = (List<MyMemberDto>)request.getAttribute("userlist");
%>
	<h1>회원정보조회</h1>
	<table border="1">
		<tr>
			<th>NO</th>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>ROLE</th>
			<th>ROLO_UPDATE</th>
		</tr>
<%
	for(MyMemberDto dto : list){
%>
		<tr>
			<td><%=dto.getMyno() %></td>
			<td><%=dto.getMyid() %></td>
			<td><%=dto.getMyname() %></td>
			<td><%=dto.getMyemail() %></td>
			<td><%=dto.getMyrole() %></td>
			<td style="text-align:center;"><button onclick="updateRole(<%=dto.getMyno() %>);">변경</button></td>
		</tr>
<%		
	}
%>
		<tr>
			<td colspan="6" align="right">
			<!-- session에 정보(dto)를 저장해 놓았기 때문에 형변환(MyMemberDto)을 해주면서 내가 필요한 id(getMyid), pw(getMypw)의 값을 가져와 목록으로 이동 -->
			<button onclick="location.href='logincontroller.jsp?command=login&id=<%=((MyMemberDto)session.getAttribute("dto")).getMyid() %>&pw=<%=((MyMemberDto)session.getAttribute("dto")).getMypw() %>'">메인</button>
			</td>
		</tr>
	</table>
</body>
</html>