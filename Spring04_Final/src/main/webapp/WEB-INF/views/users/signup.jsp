<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/users/signup.jsp</title>
</head>
<body>
	<div class="container">
		<p>
			<!-- form에서 전송되어 온 parameter을 view page에서도 당연히! 사용할 수 있다. -->
			<strong>${param.id }</strong>님 회원가입 되었습니다.
			<a href="${pageContext.request.contextPath}/users/loginform.do">로그인 하러가기</a>
		</p>
	</div>
</body>
</html>