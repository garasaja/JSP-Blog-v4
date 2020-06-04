var isCheckUsername = false;

// juso.go.kr 라이브러리 함수 (시작)
// -----------------------------------------------------------
function goPopup() {
	var pop = window.open("/blog/juso/jusoPopup.jsp", "pop",
			"width=570,height=420, scrollbars=yes, resizable=yes");
}

function jusoCallBack(roadFullAddr) {
	var tfAddress = document.querySelector("#address");
	tfAddress.value = roadFullAddr;
	// document.form.roadFullAddr.value = roadFullAddr;
}
//juso.go.kr 라이브러리 함수 (끝)
//-----------------------------------------------------------

//중복체크함수
function validate() {
	if (!isCheckUsername) {
		alert('username 중복체크를 해주세요');
	}
	return isCheckUsername;
}

//데이터베이스에 ajax 요청을 해서 중복 유저네임이 있는지 확인하고 있으면 1리턴 , 없으면 0리턴 , 오류나면 -1리턴
function usernameCheck() {
	var tfUsername = $('#username').val();
	// alert(tfUsername);//1번쨰 방법
	console.log(tfUsername);// 2번째 방법
	$.ajax({
		type : 'get',
		url : `/blog/user?cmd=usernameCheck&username=${tfUsername}`
	}).done(function(result) {
		console.log(result);
		if (result == 1) {
			alert('아이디가 중복되었습니다.');
		} else if (result == 0) {
			alert('사용하실수 있는 아이디입니다.');
			isCheckUsername = true;
		} else {
			console.log('develop : 서버 오류');
		}
	}).fail(function(error) {
		console.log(error);
	}); // 서버전송
	// isCheckUsername = true;
}
