/**
 * idCheck.js
 */

 $(function(){
	$('#delete').click(function(){
		var answer = confirm("삭제하시겠습니까");
	if(answer == true){
		$.ajax({
			url:"deleteMember",
			method:"post",
			data:{"joID":$('#joID').val() },
			success:function(result,textStatus){
			},
			error:function(data,textStatus){
				alert("에러 발생");
			},
			complete:function(data,textStatus){
				
			}
			
		 });
	   }
	});
});