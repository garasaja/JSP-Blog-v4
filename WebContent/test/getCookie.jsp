<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie cookie = new Cookie("jooho","hello; HttpOnly");
		cookie.setHttpOnly(true);
		//response.addCookie(cookie);
	%>
	<script>
	var a = document.cookie;
	console.log(a);
	</script>
</body>
</html>