$("#img__preview").on("change", function(e) {
	var f = e.target.files[0];
	if (!f.type.match("image.*")) {
		alert("이미지만 첨부해주세요");
		$("#img__preview").val('');
		return;
	}
	// f.size = 1024*1024*2
	var reader = new FileReader();
	console.log("테스트");
	reader.onload = function(e) {
		$("#img__wrap").attr("src", e.target.result);
	};
	reader.readAsDataURL(f); // 비동기
});