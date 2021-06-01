/**
 * joinMember.js
 */
// 회원가입 화면의 입력값들을 검사한다.
function checkValue() {
	var form = document.userInfo;
	
	if (!form.joName.value) {
		alert("이름을 입력하세요.");
		return false;
	}

	if (!form.joID.value) {
		alert("아이디를 입력하세요.");
		return false;
	}

	if (form.idDuplication.value != "idUncheck") {
		alert("아이디 중복체크를 해주세요.");
		return false;
	}
	
	if(!form.joPassword.value){
				alert("비밀번호를 입력하세요.");
				return false;
			}	
			
	if(!form.joEmail.value){
				alert("메일 주소를 입력하세요.");
				return false;
			}
    
    if(!form.joYear.value){
				alert("태어난 년도 4자리를 정확하게 입력하세요.");
				return false;
			}
	
	if(!form.joMonth.value){
				alert("태어난 달 2자리를 정확하게 입력하세요.");
				return false;
			}
			
	if(!form.joDate.value){
				alert("태어난 날짜를 정확하게 입력하세요.");
				return false;
			}									
}
