<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/list.jsp</title>
</head>
<body>
	<div class="container">
		<a href="insertform">할 일 추가하기</a>
		<h3>할 일 목록 보기</h3>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>할 일</th>
					<th>등록일</th>
					<th>기한</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="tmp" items="${list }">
					<tr>
						<td>${tmp.num }</td>
						<td>${tmp.content }</td>
						<td>${tmp.regdate }</td>
						<td>${tmp.deadline }</td>
						<td><a href="updateform?num=${tmp.num }">수정하기</a></td>
						<td><a href="delete?num=${tmp.num }">삭제하기</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>