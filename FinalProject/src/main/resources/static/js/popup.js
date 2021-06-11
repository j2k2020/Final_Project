/**
 * idCheck.js
 */

 $(function(){
	$('#idCheck').on('click',function(){
		
		$.ajax({
			url:"joinidCheck",
			method:"post",
			data:{"joID":$('#joID').val() },
			success:function(result,textStatus){
				if(result>0) alert("사용할 수 없는 ID입니다.");
				else alert("사용 가능한 ID입니다.");
			},
			error:function(data,textStatus){
				alert("에러 발생");
			},
			complete:function(data,textStatus){
				
			}
			
		});
	});
});