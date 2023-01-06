<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home</title>
<script src="https://cdn.jsdelivr.net/npm/vue@2.7.14/dist/vue.js"></script>
</head>
<body>
	<div class="container" id="app">
		<c:choose>
			<c:when test="${empty sessionScope.id }">
				<a href="${pageContext.request.contextPath}/users/signup_form">회원가입</a>
				<a href="${pageContext.request.contextPath}/users/loginform">로그인</a>
			</c:when>
			<c:otherwise>
				<p>
					<a href="${pageContext.request.contextPath}/users/info">${sessionScope.id }로그인 중...</a>
					<a href="${pageContext.request.contextPath}/users/logout">로그아웃</a>
				</p>
			</c:otherwise>
		</c:choose>
		<h1>인덱스 페이지입니다.</h1>
		<ul>
			<li><a href="get_msg">@ResponseBody annotation test + String</a></li>
			<li><a href="get_person">한 명의 정보(@ResponseBody Map실험)</a></li>
			<li><a href="get_user">회원 한 명의 정보(@ResponseBody Dto실험)</a></li>
			<li><a href="get_friends">친구 목록(@ResponseBody List(String)실험)</a></li>
			<li><a href="get_users">회원 목록(@ResponseBody List(UsersDto)실험)</a></li>
			<li><a href="file/list">자료실 목록 보기</a></li>
			<li><a href="cafe/list">카페 목록 보기</a></li>
			<li><a href="shop/list">과일 사러 가기</a></li>
			<li><a href="gallery/list">갤러리 목록보기</a></li>
		</ul>
		<h3>공지사항입니다.</h3>
		<ul>
			<c:forEach var="tmp" items="${noticeList }">
				<li>${tmp}</li>
			</c:forEach>
		</ul>
	</div>
	<script>
		let app = new Vue({
			el:"#app",
			methods:{
				onLogout:function(e){
					let isLogoutOk= confirm("로그아웃 하시겠습니까?");
					if(!isLogoutOk){
						e.preventDefault();
					}
				}
			}
		})
	</script>
</body>
</html>