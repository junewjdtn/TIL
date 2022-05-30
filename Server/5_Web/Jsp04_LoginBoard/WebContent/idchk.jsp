<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IdChk Page</title>
<script type="text/javascript">
	window.onload = function(){
		// opener : 팝업창을 열어준 브라우저의 
		let id = opener.document.getElementsByName("myid")[0].value;
	
		// 현재(팝업창)의 요소
		document.getElementsByName("id")[0].value=id;
	}
	
	function confirm(bool){
		if(bool == "true"){
			opener.document.getElementsByName("mypw")[0].focus();
			/* title은 중복체크를 했는지 하지 않았는지 확인하기 위해 만들어 놓음 */
			opener.document.getElementsByName("myid")[0].title="y";
		}else {
			opener.document.getElementsByName("myid")[0].focus();
		}
		self.close();
	}
</script>
</head>
<body>
<%
	String idnotused = request.getParameter("idnotused");
%>
	<table border="1">
		<tr>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<%-- <td align="center"><%=idnotused.equals("true")? "사용 가능" : "사용 불가" %></td> --%>
			<td align="center">
				<%
					if(idnotused.equals("true")){
				%> 
					<p style="color:green">사용 가능</p>
				<%
				}else { 
				%> 
					<p style="color:red">사용 불가</p> 
				<% 
				} 
				%>
			</td>
		</tr>
		<tr>
			<td>
				<input type="button" value="확인" onclick="confirm('<%=idnotused %>');">
			</td>
		</tr>
	</table>
</body>
</html>