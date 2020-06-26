<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- CDN -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- RWD -->
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Insert title here</title>
</head>
<body>


<%
Object username=session.getAttribute("username");
%>


<div class="container-fluid">
		<div class="row">
			<div class="col-md-6 offset-md-3">
			
			
				<form action="login" method="post">
				
					<h1 class="h3 mb-3 font-weight-normal"> 請登入</h1>
					
					<div class="form-group">
						<input type="text" name="username" value="<%=username==null?"":username %>" class="form-control" placeholder="帳號" > <br>
					</div>
					
					<div class="form-group">
						 <input type="password" name="userpass" class="form-control" placeholder="密碼" > <br>
					</div>
					
					<button type="submit" class="btn btn-lg btn-primary btn-block" value="submit">登入 </button><br>
					
					
					<input type ="button" onclick="window.location='register.jsp'" value="註冊"></input>
					
					
					<input type ="button" onclick="window.location='searchdata.jsp'" value="忘記了?"></input>
					
					
				</form>
				
			</div>
		</div>
	</div>








<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>