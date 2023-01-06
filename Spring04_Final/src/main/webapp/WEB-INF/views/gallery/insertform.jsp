<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/gallery/insertform</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js" integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h3>갤러리 포스팅 추가하기</h3>
		<form action="imageUpload" method="post" id="fileForm" enctype="multipart/form-data">
			<div>
				<label for="image">사진 첨부</label>
				<input type="file" name="mFile" id="image" accept=".jpg, .png, .gif" />
			</div>
		</form>
		<form action="insert" method="post">
			<div>
				<label for="caption">사진 설명</label>
				<input type="text" name="caption" id="caption" />
			</div>
			<input type="hidden" name="imagePath" />
			<button type="submit">제출하기</button>
		</form>
	</div>
		<!-- gura_util.js 로딩 -->
	<script src="${pageContext.request.contextPath }/resources/js/gura_util.js"></script>
	<script>
		//프로필 이미지를 선택하면(바뀌면) 실행할 함수 등록
		document.querySelector("#image").addEventListener("change", function() {
			//ajax 전송할 폼의 참조값 얻어오기
			const form = document.querySelector("#fileForm");
			//gura_util.js 에 있는 함수를 이용해서 ajax 전송하기 
			ajaxFormPromise(form)
			.then(function(response) {
				return response.json();
			})
			.then(function(data) {
				console.log(data);
				// input name="profile" 요소의 value 값으로 이미지 경로 넣어주기
				document.querySelector("input[name=imagePath]").value = data.imagePath;
				console.log(document.querySelector("input[name=imagePath]").value);
			});
		});
	</script>
</body>
</html>