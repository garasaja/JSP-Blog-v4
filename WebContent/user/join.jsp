<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>


<div class="container">
	<form action="/blog/user?cmd=joinProc" method="POST"
		class="was-validated">

		<!-- 아이디 -->
		<div class="form-group">
			<label for="username">Username:</label> <input type="text"
				class="form-control" id="username" placeholder="Enter username"
				name="username" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<!-- 비밀번호-->
		<div class="form-group">
			<label for="pwd">Password:</label> <input type="password"
				class="form-control" id="password" placeholder="Enter password"
				name="password" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<!-- 이메일 -->
		<div class="form-group">
			<label for="email">Email:</label> <input type="email"
				class="form-control" id="email" placeholder="Enter email"
				name="email" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<!-- 주소 -->
		<div class="form-group">
			<label for="address">Address:</label> <input type="text"
				class="form-control" id="address" placeholder="Enter address"
				name="address" required>
			<div class="valid-feedback">Valid.</div>
			<div class="invalid-feedback">Please fill out this field.</div>
		</div>

		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>


<%@ include file="../include/footer.jsp"%>
