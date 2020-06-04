<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ include file="../include/nav.jsp"%>
<%@ include file="../include/authentication.jsp"%>



<div class = "container">
<form action="/blog/board?cmd=writeProc" method="POST">

	<!-- 제목 적는곳 -->
	<div class="form-group">
		<label for="title">Title:</label>
		<input type="text" class="form-control" placeholder="title" id="title" name="title">
	</div>

	<!-- 텍스트 적는곳 -->
	<div class="form-group">
		<label for="content">Content:</label>
		<textarea class="form-control" rows="5" id="content" name ="content"></textarea><!-- textarea는 text값을 textare 여기/textarea에서 찾는다 -->
	</div>

	<button type="submit" class="btn btn-primary">글쓰기 등록</button>
</form>
</div>


<%@ include file="../include/footer.jsp"%>