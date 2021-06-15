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
	
	if(!form.joPassword.value){
				alert("비밀번호를 입력하세요.");
				return false;
			}

			
	 var ctr = 0;	 
		 if(form.joPassword.value.search(/[0-9]/g) != -1 ) ctr ++;
		 if(form.joPassword.value.search(/[a-z]/ig)  != -1 ) ctr ++;
		 if(form.joPassword.value.search(/[!@#$%^&*()?_~]/g)  != -1  ) ctr ++;
		 if(ctr < 2)
		 { 
		  alert("비밀번호는 숫자, 영문, 특수문자를 두가지이상 혼용하여야 합니다."); 
		  return false;
		 }
         if(form.joPassword.value.length<6 || form.joPassword.value.length>13){
			alert("비밀번호는 6자 이상 13자 이하입니다.");
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
