<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>인덱스입니다.</h1>
		<ul>
			<li><a href="${pageContext.request.contextPath}/member/insertform">요청 파라미터 추출 테스트(by.회원추가)</a></li>
			<li><a href="${pageContext.request.contextPath}/move/test">이동 테스트</a></li>
			<li><a href="di/test">Dependency Injection 테스트</a></li>
		</ul>
		<h3>공지사항</h3>
		<ul>
		</ul>
	</div>
</body>
</html>