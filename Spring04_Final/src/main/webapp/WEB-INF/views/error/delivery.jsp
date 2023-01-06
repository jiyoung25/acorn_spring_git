<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/error/delivery</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h3>배송 관련 에러입니다.</h3>
		<p class="alert alert-danger">
			<%--
				예외 컨트롤러에서
				ModelAndView mView = new ModelAndView();
				mView.addObject("exception",de);
				exception이라는 키값으로 예외 객체를 담았기 때문에,
				예외 메시지는
				${exception.message }(는 ${exception.getMessage() }를 대신한다.)
				로 출력한다.
			 --%>
			<strong>${exception.message }</strong>
		</p>
		<p class="alert alert-info">
			${info }
		</p>
		<a href="${pageContext.request.contextPath}/">인덱스로 돌아가기</a>
		
	</div>
</body>
</html>