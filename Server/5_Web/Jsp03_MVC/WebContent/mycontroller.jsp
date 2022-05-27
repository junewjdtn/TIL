<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>    
<% response.setContentType("text/html; charset=UTF-8"); %>

<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page import="com.mvc.dao.MVCBoardDao" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Controller Page</title>
</head>
<body>
<%
/* boardlist */
	String command = request.getParameter("command");

	MVCBoardDao dao = new MVCBoardDao();	

	System.out.println("[command: " + command + "]");
	
	if(command.equals("boardlist")){
		List<MVCBoardDto> list = dao.selectAll();	
		
		// request 객체에 'allList'라는 이름의 'list'데이터를 담아 넘겨준다.
		request.setAttribute("allList", list);
		pageContext.forward("boardlist.jsp");
		/*
			forward  : request 객체, response 객체가 유지 (request객체와 response 객체가 같이 넘어감)
			redirect : 새로운 request객체와 response객체가 새로운 페이지를 요청한것과 같은 방식으로 페이지 이동
		*/
		
/* boardinsertform */
	}else if(command.equals("boardinsertform")){
		// 'boardinsert.jsp'로 보내겠다
		response.sendRedirect("boardinsert.jsp");

/* boardinsert */
	}else if(command.equals("boardinsert")){
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setWriter(writer);
		dto.setTitle(title);
		dto.setContent(content);
		
		int res = dao.insert(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("게시글 작성 완료");
			location.href='mycontroller.jsp?command=boardlist';
		</script>
<%
		} else {
%>
		<script type="text/javascript">
			alert("게시글 작성 실패");
		</script>
<%
			response.sendRedirect("mycontroller.jsp?command=boardinsertform");
		}
		
/* boarddetail */		
	} else if(command.equals("boarddetail")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = dao.selectOne(seq);
		
		request.setAttribute("oneList", dto);
		pageContext.forward("boarddetail.jsp");
		
/* boardupdateform */
	} else if(command.equals("boardupdateform")){
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = dao.selectOne(seq);
		
		request.setAttribute("update", dto);
		pageContext.forward("boardupdate.jsp");

/* boardupdate */
	} else if(command.equals("boardupdate")){
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int seq = Integer.parseInt(request.getParameter("seq"));
		
		MVCBoardDto dto = new MVCBoardDto();
		dto.setTitle(title);
		dto.setContent(content);
		dto.setSeq(seq);
		
		int res = dao.update(dto);
		
		if(res>0){
%>			
		<script type="text/javascript">
			alert("게시글 수정 완료");
			location.href="mycontroller.jsp?command=boarddetail&seq="+<%=seq %>;
		</script>
<%
		} else {
%>			
		<script type="text/javascript">
			alert("게시글 수정 실패");
			location.href="mycontroller.jsp?command=boardupdateform&seq="+<%=seq %>;
		</script>
<%		
		}
		
/* muldel(selectDelete) */
	} else if(command.equals("muldel")){
		String[] seq = request.getParameterValues("chk");
		int res = dao.selectDelete(seq);
		
		if(res == seq.length){
%>			
		<script type="text/javascript">
			alert("게시글 삭제 성공");
			location.href="mycontroller.jsp?command=boardlist";
		</script>		
<%		
		}else {
%>
		<script type="text/javascript">
			alert("게시글 삭제 실패");
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%			
		}
		
/* boarddetail -> boarddelete */
	} else if(command.equals("boarddelete")){
		String[] seq = new String[1];
		seq[0] = request.getParameter("seq");
		
		int res = dao.selectDelete(seq);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("게시글 삭제 성공");
			location.href="mycontroller.jsp?command=boardlist";
		</script>
<%
		} else {
%>			
		<script type="text/javascript">
			alert("게시글 삭제 실패")
			location.href="mycontroller.jsp?command=boarddetail&seq="<%=seq%>;
		</script>
<%		
		}
		
	}
%>

</body>
</html>