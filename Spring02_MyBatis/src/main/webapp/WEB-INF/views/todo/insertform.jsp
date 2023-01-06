<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/todo/insertform</title>
<script src="https://cdn.jsdelivr.net/npm/vue@2.7.14/dist/vue.js"></script>
</head>
<body>
	<div class="container">
		<h3>할 일 추가하기</h3>
		<form action="insert" v-on:submit="onSubmit" id="insert">
			<div>
				<label for="content">할 일</label>
				<input type="text" name="content" id="content" v-model="content" />
			</div>
			<div>
				<label for="deadline">기한</label>
				<input type="date" name="deadline" id="deadline" v-model="deadline" />
			</div>
			<button type="submit">제출하기</button>
		</form>
	</div>
	<script>
		new Vue({
			el : "#insert",
			data : {
				content:"",
				deadline: null
			},
			methods : {
					onSubmit : function(e){
						if(this.content == ""){
							e.preventDefault();
							alert("할 일을 필수로 적어주세요.");
						}
						if(this.deadline==null){
							e.preventDefault();
							alert("기한을 정해주세요.");
						}
						
						
					}
			}
			
		})
	</script>
</body>
</html>