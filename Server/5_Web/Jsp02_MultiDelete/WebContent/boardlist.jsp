<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.multi.dao.MDBoardDao" %>
<%@ page import="com.multi.dto.MDBoardDto" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>board list Page</title>
<style>
	a{text-decoration: none;}
</style>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
	function allChk(bool){
		let chks = document.getElementsByName("chk");
		for(let i=0; i<chks.length; i++){
			chks[i].checked = bool;
		}
	}
	
	// 체크 하나라도 안하면 submit 취소
	$(function(){
		$("#muldelform").submit(function(){
			if( $("#muldelform input:checked").length == 0){
				alert('하나 이상 체크해 주세요');
				return false;
			}
		});
	});
</script>
</head>
<body>
<%
	MDBoardDao dao = new MDBoardDao();
	List<MDBoardDto> list = dao.selectAll();
%>
<!-- 컴파일할때 파일을 실행함 -->
<%@ include file="./form/header.jsp" %>
	
	<h1>글 목록</h1>
	<form id="muldelform" action="muldel.jsp" method="post">
		<table border=1>
			<col width="30px">
			<col width="50px">
			<col width="100px">
			<col width="300px">
			<col width="100px">
			<tr>
				<th><input type="checkbox" name="all" onclick="allChk(this.checked);"></th>
				<th>NO</th>
				<th>WRITER</th>
				<th>TITLE</th>
				<th>DATE</th>
			</tr>
<% 
			if(list.size() == 0){
%>
			<tr>
				<td colspan="5" align="center"><b>---- 게시글이 존재하지 않습니다. ----</b></td>
			</tr>
<%
			} else {
				for(MDBoardDto dto : list){
%>
			<tr align="center">
				<td><input type="checkbox" name="chk" value="<%=dto.getSeq()%>"></td>
				<td><%=dto.getSeq() %></td>
				<td><%=dto.getWriter() %></td>
				<td><a href="boarddetail.jsp?seq=<%=dto.getSeq() %>"><%=dto.getTitle() %></a></td>
				<td><%=dto.getRegdate() %></td>
			</tr>
<%					
				}
			}
%>
			<tr>
				<td colspan="4">
					<input type="submit" value="삭제">
				</td>
				<td align="right">
					<input type="button" value="글쓰기">
				</td>
			</tr>
		</table>
	</form>
<%@ include file="./form/footer.jsp" %>
</body>
</html>