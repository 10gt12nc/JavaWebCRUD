<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


		SessionID:<%=session.getId() %><br><br>
		isNew:<%=session.isNew() %><br><br>
		MaxInactiveInterval:<%=session.getMaxInactiveInterval() %><br><br>
		CreationTime:<%=session.getCreationTime() %><br><br>
		LastAccessedTime:<%=session.getLastAccessedTime() %><br><br>

		886:<%=session.getAttribute("username")%>
		
		<% 
			session.invalidate();
		%>
		
		
		<input type ="button" onclick="window.location='login.jsp'" value="回登入頁"></input>


</body>
</html>