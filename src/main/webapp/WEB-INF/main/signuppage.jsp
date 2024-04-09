<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<h3>회원 가입</h3>
	<form action="/signup" method="POST">
		<label for="firstName">
			성 : 
			<input type="text" name="firstName" id="firstName">
		</label>
		<label for="secondName">
			이름 : 
			<input type="text" name="secondName" id="secondName">
		</label>
		<br>
		<label for="id">
			아이디 : 
			<input type="text" name="id" id="id">
		</label>
		<br>
		<label for="pw">
			비밀번호 : 
			<input type="password" name="pw" id="pw">
		</label>
		<br>
		<label for="email">
			이메일 : 
			<input type="email" name="email" id="email">
		</label>
		<br>
		<label>
			<input type="checkbox" name="agreement" id="agreement">약관에 동의하기
		</label>
		<br>
		<button type="submit">가입하기</button>
		<br>
		또는 소셜로 가입하기
		<br>
		<a href="/oauth2/authorization/google">구글</a>
		<a>카카오(미완)</a>		
		<br>
		이미 아이디가 있으신가요 ? <a href="/signin">로그인</a>
	</form>
</body>
</html>