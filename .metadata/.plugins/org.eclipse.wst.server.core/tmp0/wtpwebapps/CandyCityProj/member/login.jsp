<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="/css/mainStyle.css">
<link rel="stylesheet" href="/css/loginStyle.css">
</head>
<body>
	<div class="window">
		<button class="widow_btn" id="-_btn">-</button>
		<button class="widow_btn" id="x_btn">X</button>
	</div>
	
	<div class="wrapper">
		
	
		<div class="login">
			<div class="window">
				<button class="widow_btn" id="-_btn">-</button>
				<button class="widow_btn" id="x_btn">X</button>
			</div>

			<form action="/login" method="get" id="loginForm">

				<h2>Candy City Login</h2>

				<div class="login_center">
					<label><b>User ID</b></label> <input type="text"
						placeholder="아이디를 입력해주세요." name="id"> 
						
					<label><b>Password</b> <input type="password"
						placeholder="패스워드를 입력해주세요." name="pwd"></label>
					<br><br>
					<input type="submit" value="로그인"> 
					
					<ul>
						<li><a href="../index.jsp"> 메인페이지로 </a></li>
						<li><a href="/member/insertMember.jsp"> 회원 가입 </a></li>
					</ul>
				</div>
			</form>
		</div>


	</div>
</body>
</html>