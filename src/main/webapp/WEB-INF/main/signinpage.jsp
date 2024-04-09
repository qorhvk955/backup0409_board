<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
</head>
<body>
	<h3>로그인</h3>
	<form action="${pageContext.request.contextPath}/login_proc" method="POST">
		아이디 : <input type="text" name="username" id="username"><br>
		비밀번호 : <input type="text" name="password" id="password"><br>
		로그인 유지 : <input type="checkbox" name="remember-me" id="rememberMe"><br>
		<button type="submit">로그인</button>
	</form>
	<a href="/signup">회원 가입</a>
	<a href="/oauth2/authorization/google">구글로 로그인</a>
</body>
</html>