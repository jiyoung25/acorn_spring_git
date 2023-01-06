<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>views/cafe/detail_practice.jsp</title>
</head>
<body>
	<div class="container">
		<c:if test="${dto.prevNum ne 0 }">
			<a href="detail?num=${dto.prevNum }&condition=${condition }&keyword=${encodedK }">이전</a>
		</c:if>
		<c:if test="${dto.nextNum ne 0 }">
			<a href="detail?num=${dto.nextNum }&condition=${condition }&keyword=${encodedK }">다음</a>
		</c:if>
		<h3>글 상세 보기</h3>
		<table>
			<tr>
				<th>글번호</th>
				<td>${dto.getNum() }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${dto.getWriter() }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${dto.getTitle() }</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${dto.getViewCount() }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${dto.getRegdate() }</td>
			</tr>
			<tr>
				<td colspan="2">
					<div>${dto.getContent() }</div>
				</td>
			</tr>
		</table>
		<c:if test="${id eq dto.writer }">
			<a href="updateform?num=${dto.num }">수정</a>
			<a href="javascript:" onclick="deleteConfirm()">삭제</a>
			<script>
				function deleteConfirm(){
					const isDelete = confirm("이 글을 삭제하시겠습니까?");
					if(isDelete){
						location.href = "delete?num=${dto.num}";
					}
				}
			</script>
		</c:if>
		<c:if test="${not empty keyword }">
			<p>
				<strong>${condition }</strong>조건 <strong>${keyword }</strong>검색어로 
				검색된 내용 자세히 보기
			</p>
		</c:if>
		<h3>댓글을 입력해 주세요.</h3>
		<form class="comment-form insert-form" action="comment_insert" method="post">
			<input type="hidden" name="ref_group" value="${dto.num }" />
			<input type="hidden" name="target_id" value="${dto.writer }" />
			<textarea name="content">${empty id? '댓글 작성을 위해 로그인이 필요합니다.':'' }</textarea>
			<button type="submit">등록</button>
		</form>
		<div class="comments">
			<ul>
				<c:forEach var="tmp" items="${commentList }">
					<c:choose>
						<c:when test="${tmp.deleted eq 'yes' }">
							<li>삭제된 댓글입니다.</li>
						</c:when>
						<c:otherwise>
							<c:if test="${tmp.num eq tmp.comment_group }">
								<li id="reli${tmp.num }"></li>
							</c:if>
							<c:if test="${tmp.num ne tmp.comment_group }">
								<li id="reli${tmp.num }" style="padding-left: 50px;">
									<svg class="reply-icon" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
										class="bi bi-arrow-return-right" viewBox="0 0 16 16">
                             			<path fill-rule="evenodd"
											d="M1.5 1.5A.5.5 0 0 0 1 2v4.8a2.5 2.5 0 0 0 2.5 2.5h9.793l-3.347 3.346a.5.5 0 0 0 .708.708l4.2-4.2a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 8.3H3.5A1.5 1.5 0 0 1 2 6.8V2a.5.5 0 0 0-.5-.5z" />
                        			</svg>
							</c:if>
							<dl>
								<dt>
									<c:if test="${not empty tmp.profile }">
										<img src="${pageContext.request.contextPath}${tmp.profile }" alt="" class="profile-image" />
									</c:if>
									<span>${tmp.writer }</span>
									<c:if test="${tmp.num ne tmp.comment_group }">
										@<i>${tmp.target_id }</i>
									</c:if>
									<span>${tmp.regdate }</span>
									<a data-num="${tmp.num } href="javascript:" class="reply-link">답글</a>
									<c:if test="${ (id ne null) and (tmp.writer eq id) }">
										<a href="javascript:" class="update-link" data-num="${tmp.num }">수정</a>
										<a href="javascript:" class="delete-link" data-num="${tmp.num }">삭제</a>
									</c:if>
								</dt>
								<dd>
									<pre id="pre${tmp.num }">${tmp.content }</pre>
								</dd>
							</dl>
							<form action="comment_insert" id="reForm${tmp.num } class="animate__animated comment-form re-insert-form" method="post">
								<input type="hidden" name="num" value="${tmp.num }" />
								<textarea name="content">${tmp.content }</textarea>
								<button type="submit">수정</button>
							</form>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ul>
		</div>
	</div>
</body>
</html>