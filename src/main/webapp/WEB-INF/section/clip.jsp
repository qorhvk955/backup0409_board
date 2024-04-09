<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영상 게시판</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<h3>영상 게시판</h3>
	<hr>
	<div>
		<table border=1>
			<tr>
				<td>게시글 번호</td>
				<td>제목</td>
				<td>내용</td>
				<td>등록 날짜</td>
				<td>수정 날짜</td>
				<td>파일</td>
			</tr>
			<c:forEach items="${list}" var="board">
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
	</div>
		<form action="" id="actionForm" method="get">
			<input type="hidden" name="pageNum" value="${page.cv.pageNum}">
			<input type="hidden" name="amount" value="${page.cv.amount}">
		</form>
	<div>
		<c:if test="${page.prev}">
			<a class="pageBtn" href="${page.startPage-1}"> [prev] </a>
		</c:if>
		<c:forEach var="num" begin="${page.startPage}" end="${page.endPage}" step="1">
			<a class="pageBtn" href="${num}">${num}</a>
		</c:forEach>
		<c:if test="${page.next}">
			<a class="pageBtn" href="${page.endPage+1}"> [next] </a>
		</c:if>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			
			let actionForm = $('#actionForm');
			
			$('.pageBtn').on("click", function(e){
				e.preventDefault();
				actionForm.find("input[name='pageNum']").val($(this).attr("href"));
				actionForm.submit();
			})
			
		})
	</script>
</body>
</html>