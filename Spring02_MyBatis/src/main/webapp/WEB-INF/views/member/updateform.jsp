<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/updateform</title>
</head>
<body>
	<div class="container">
		<h3>updateform</h3>
		<form action="update">
			<input type="hidden" name="num" value="${dto.num }" />
			<div>
				<label for="num">번호</label>
				<input type="text" id="num" value="${dto.num }" readonly />
			</div>
			<div>
				<label for="name">이름</label>
				<input type="text" name="name" id="name" value="${dto.name }" />
			</div>
			<div>
				<label for="addr">주소</label>
				<input type="text" name="addr" id="addr" value="${dto.addr }" />
			</div>
			<button type="submie">수정 확인</button>
			<button type="reset">수정 취소</button>
		</form>
	</div>
</body>
</html>