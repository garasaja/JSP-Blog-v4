	function deleteById(boardId) {
		$.ajax({
			type: "POST",
			url: "/blog/board?cmd=delete&id="+boardId,
			dataType: "text"
			}).done(function(result){
			if(result == 1) {
				alert("삭제성공");
				location.href="/blog/index.jsp";
				} else {
					alert("삭제실패");
					}
			}).fail(function(error){
				alert("서버 오류");
			});
	}
