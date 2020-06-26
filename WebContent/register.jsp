<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<font color="red">${message}</font>

	<form action="registercheck.jsp" method="post">
		名稱(1~16):<input type="text" name="username" size="25" maxlength="16"><br><br>
		
		密碼(6~16):<input type="password" name="password" size="25" maxlength="16"><br><br>
		
		密碼確認:<input type="password" name="password2" size="25" maxlength="16"><br><br>
		
		電子郵件:<input type="text" name="email" size="25" maxlength="100"><br><br>
		
		<input type="submit"  value="確認">
		
		<input type ="button" onclick="history.back()" value="回到上一頁"></input>
		
		<input type ="button" onclick="window.location='login.jsp'" value="回登入頁"></input>
		
		
		
		
	</form>


</body>
</html>