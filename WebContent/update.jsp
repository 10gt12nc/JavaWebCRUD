<%@page import="tw.com.lin.bean.Customer"%>
<%@page import="java.util.List"%>
<%@page import="tw.com.lin.factory.CustomerFactory"%>
<%@page import="tw.com.lin.dao.CustomerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%=request.getAttribute("search") 

%>


<form action="update" method="post">


	id<input type="text" name="id" ><br><br>

	密碼(6~16):<input type="text" name="password" ><br><br>
		
	密碼確認:<input type="text" name="password2" ><br><br>
		
		
	<input type="submit"  value="確認">


</form>


刪除


<input type="button" onclick="window.location='login.jsp'" value="回登入頁"></input>



</body>
</html>