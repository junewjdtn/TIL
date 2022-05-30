<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% request.setCharacterEncoding("UTF-8"); %>   
<% response.setContentType("text/html; charset=UTF-8"); %> 

<%@page import="java.util.List"%>
<%@page import="com.login.dao.MyMemberDao"%>
<%@page import="com.login.dto.MyMemberDto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginController Page</title>
</head>
<body>
<%
	/* command에 들어가 있는 내용을 불러오는 작업 */
 	String command = request.getParameter("command");
	System.out.println("[Command: " + command + "]");
	
	MyMemberDao dao = new MyMemberDao();
	
	if(command.equals("login")){
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MyMemberDto dto = dao.login(id, pw);
		
		if(dto.getMyid() != null){
			// session : 브라우저 전체에서 공유됨 (영역의미)
			session.setAttribute("dto", dto);
			
			// session에 공유되는 정보를 시간을 설정하여 그 시간만큼만 사용 가능하게 설정하는 방법
			// session에 담긴 객체가 살아있는 시간(초단위)
			session.setMaxInactiveInterval(60*60);
			
			// 등급이 'ADMIN'일때
			if(dto.getMyrole().equals("ADMIN")){
				// 'adminmain.jsp' 페이지로 이동
				response.sendRedirect("adminmain.jsp");
			// 등급이 'USER'일때	
			}else if(dto.getMyrole().equals("USER")){
				// 'usermain.jsp' 페이지로 이동
				response.sendRedirect("usermain.jsp");
			}	
		} else {
%>			
			<script type="text/javascript">
				alert("login 실패");
				location.href="index.jsp";
			</script>		
<%			
		}
	} else if(command.equals("logout")){
		// session 정보 삭제
		session.invalidate();
		response.sendRedirect("index.jsp");
		
	} else if(command.equals("userlistall")){
		List<MyMemberDto> list = dao.userListAll();
		request.setAttribute("userlist", list);
		pageContext.forward("userlistall.jsp");
		
	} else if(command.equals("registform")){
		response.sendRedirect("registform.jsp");
		
	} else if(command.equals("idchk")){
		String myid = request.getParameter("id");
		String res = dao.idChk(myid);
		// res에는 아이디가 중복되면 중복된 아이디 값이 오고 중복이 되지 않으면 null이 넘어옴
		
		boolean idnotused = true;
		
		// id값이 중복이 되었을때
		if(res != null){
			idnotused = false;	
		}
		
		response.sendRedirect("idchk.jsp?idnotused=" + idnotused);
		
	} else if(command.equals("insertuser")){
		String myid = request.getParameter("myid");
		String mypw = request.getParameter("mypw");
		String myname = request.getParameter("myname");
		String myaddr = request.getParameter("myaddr");
		String myphone = request.getParameter("myphone");
		String myemail = request.getParameter("myemail");
		
		MyMemberDto dto = new MyMemberDto();
		dto.setMyid(myid);
		dto.setMypw(mypw);
		dto.setMyname(myname);
		dto.setMyaddr(myaddr);
		dto.setMyphone(myphone);
		dto.setMyemail(myemail);
		
		int res = dao.insertUser(dto);
		
		if(res>0){
%>
		<script type="text/javascript">
			alert("회원가입 완료");
			location.href="index.jsp";
		</script>
<%
			
		}else {
%>
		<script type="text/javascript">
			alert("회원가입 실패");
			location.href="logincontroller.jsp?command=registform";
		</script>
<%
		}
	}
%>
</body>
</html>