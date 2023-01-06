<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/webapp/WEB-INF/home.jsp</title>
</head>
<body>
	<div class="container">
		<h1>인덱스 페이지입니다.</h1>
		<%-- Spring Boot에서 추가된 static폴더에 있는 자원 사용하기 --%>
		<img src="${pageContext.request.contextPath}/images/bottle.png" alt="" />
		<%--
			 Resources Handler 설정으로 추가한 resources 폴더에 있는 자원 사용하기
			 static 폴더와 달리 jsp페이지도 관리할 수 있다.
			 controller를 사용하지 않고도 jsp페이지를 부를 수 있다는 말이다.
		 --%>
		<img src="${pageContext.request.contextPath}/resources/images/kim1.png" alt="" />
		<br />
		<a href="${pageContext.request.contextPath}/resources/test.jsp">
			Resources Handler의 jsp페이지 사용하기
		</a>
		<p>아래의 링크를 클릭해서 system 콘솔창에 MyInterceptor가 관여하는지 안하는지 확인하기</p>
		<a href="${pageContext.request.contextPath}/users/info">인터셉터 동작 확인</a>
		<a href="${pageContext.request.contextPath}/users/loginform">인터셉터 동작 확인2</a>
		<h3>공지사항</h3>
		<ul>
			<c:forEach var="tmp" items="${noticeList }">
				<li>${tmp }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>