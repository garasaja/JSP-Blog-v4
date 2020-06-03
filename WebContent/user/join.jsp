<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="container">
	<form action="/blog/user?cmd=joinProc" method="POST" class="was-validated" onsubmit="return validate()">

		<!-- 아이디 -->
		<div class="form-group">
			<label for="username">Username:</label>
			<button type="button" class="btn btn-warning float-right" onclick="usernameCheck()">중복확인</button>
			<input type="text" class="form-control" id="username" placeholder="Enter username" name="username" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<!-- 비밀번호-->
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password" class="form-control" id="password" placeholder="Enter password" name="password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<!-- 이메일 -->
		<div class="form-group">
			<label for="email">Email:</label> <input type="email" class="form-control" id="email" placeholder="Enter email" name="email" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<!-- 주소 -->
		<div class="form-group">
			<label for="address">Address:</label>
			<button type="button" class="btn btn-warning float-right" onclick="goPopup()">주소검색</button>
			<!-- inline block(자기 자리만 차지)일때만 float-right(오른쪽 배치) -->

			<input type="text" class="form-control" id="address" placeholder="Enter address" name="address" required readonly>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<script>
function goPopup(){
	var pop = window.open("/blog/juso/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr){
	var tfAddress = document.querySelector("#address");
	tfAddress.value = roadFullAddr;
	// document.form.roadFullAddr.value = roadFullAddr;		
}

</script>

<script>
var isCheckUsername = false;
	function validate() {
		if(!isCheckUsername) {
			alert('username 중복체크를 해주세요');
			}
		return isCheckUsername;
}

function usernameCheck() {
	var tfUsername = $('#username').val();
	//alert(tfUsername);//1번쨰 방법
	console.log(tfUsername);//2번째 방법
	$.ajax({
		type:'get',
		url: '/blog/user?cmd=usernameCheck&username='+tfUsername
	}).done(function(result){
		console.log(result);
		if(result ==1) {
			alert('아이디가 중복되었습니다.');
		}else if (result==0) {
			alert('사용하실수 있는 아이디입니다.');
			isCheckUsername = true;
		}else {
			console.log('develop : 서버 오류');
		}
	}).fail(function(error){
		console.log(error);
	});	//서버전송
	//isCheckUsername = true;
}
</script>

<%@ include file="../include/footer.jsp"%>
