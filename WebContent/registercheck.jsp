<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



資料確認




		

<form action="register" method="post">

		名稱(1~16):<input type="text" name="username" value="${param.username}"><br><br>
		
		密碼(6~16):<input type="text" name="password" value="${param.password}"><br><br>
		
		密碼確認:<input type="text" name="password2" value="${param.password2}"><br><br>
		
		電子郵件:<input type="text" name="email" value="${param.email}" ><br><br>
		
		<input type="submit"  value="確認">

</form>

<input type ="button" onclick="history.back()" value="回到上一頁"></input>

<input type ="button" onclick="window.location='login.jsp'" value="回登入頁"></input>


</body>
</html>