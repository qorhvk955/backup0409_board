<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>

</head>



<body>

	<h3>메인 페이지</h3>
	<a href="/signin">로그인</a>
	<a href="/signup">회원가입</a>
	<hr>
	
	<a>홈</a>
	<a >VR 아카이빙</a>
	<a>영상 게시판</a>
	<a>디지털 조감도</a>
	
	<hr>
	
	<section>
		검색창
	</section>
	
	<hr>
	<section>
		<h3>VR 아카이빙</h3> <a href="/vr">더보기</a>
			<table border=1>
				<tr>
					<td>게시글 번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>작성 년도</td>
					<td>등록 날짜</td>
					<td>수정 날짜</td>
					<td>파일</td>
				</tr>
				<c:forEach items="${vrList}" var="board">				
					<tr>
						<td>${board.boardNo}</td>
						<td>${board.boardTitle}</td>
						<td>${board.boardContent}</td>
						<td>${board.boardWriteYear}</td>
						<td>${board.regDate}</td>
						<td>${board.modDate}</td>

				        <td>
           					<img src="/images/${board.boardFile}" alt="Image" height="100" width="100">
        				</td>					
					</tr>
				</c:forEach>
			</table>
	</section>
	
	<hr>
	<section>
		<h3>영상 게시판</h3> <a href="/clip">더보기</a>
				<table border=1>
				
				<tr>
					<td>게시글 번호</td>
					<td>제목</td>
					<td>내용</td>
					<td>등록 날짜</td>
					<td>수정 날짜</td>
					<td>파일</td>
				</tr>
				<c:forEach items="${videoList}" var="board">
				
					<tr>
						<td>${board.boardNo}</td>
						<td>${board.boardTitle}</td>
						<td>${board.boardContent}</td>
						<td>${board.regDate}</td>
						<td>${board.modDate}</td>
				        <td>
           					<img src="/images/${board.boardFile}" alt="Image" height="100" width="100">
        				</td>						
					</tr>
				</c:forEach>
				</table>
	</section>
	
	<hr>
	<section>
		<h3>디지털 조감도</h3> <a href="viewmap">더보기</a>

	</section>
	
	<hr>
	<footer>
		<h3>푸터 섹션</h3>
	</footer>
	
	
	
</body>
</html>