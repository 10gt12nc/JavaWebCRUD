<%@page import="tw.com.lin.bean.Customer"%>
<%@page import="java.util.List"%>
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
		List<Customer> cus = (List<Customer>) request.getAttribute("cus");
	%>
	
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>PASS</th>
			<th>EMAIL</th>
		</tr>
		
			<%
				for (Customer customer : cus ) {
			%>
			
			<tr>
				<td><%=customer.getId()%></td>
				<td><%=customer.getUsername()%></td>
				<td><%=customer.getPassword()%></td>
				<td><%=customer.getPassword2()%></td>
				<td><%=customer.getEmail()%></td>
			</tr>
			
			
			
<form action="update" method="post">


	請輸入:<input type="hidden" name="id" value=" <%=customer.getId()%>" ><br><br>

	更改密碼(6~16):<input type="text" name="password" ><br><br>
		
	密碼確認:<input type="text" name="password2" ><br><br>
		
	<input type="submit"  value="確認">
	
</form><br><br>
	
	
<form action="delete" method="post">

刪除:<input type="hidden" name="id" value=" <%=customer.getId()%>" ><br><br>
	<input type="submit"  value="確認">
	
</form><br><br>
	
	
			<%
				}
			%>
			
			<input type="button" onclick="window.location='login.jsp'" value="回登入頁"></input>
			
	</table>
</body>
</html>