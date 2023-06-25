<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Gasoek+One&family=Gothic+A1:wght@300&family=Monomaniac+One&family=Nanum+Gothic:wght@400;700&family=Noto+Sans+KR&display=swap" rel="stylesheet">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">

.container{
   margin-top: 50px;
}
.row{
   margin: 0px auto;
   width:350px;
}
h1{
  text-align: center;
  font-family: 'Gasoek One', sans-serif;
  
}
</style>
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
//자바스크립트 라이브러리 
/*
 *   let id=document.querySelector("#id")
            ---------------------- $
            => 값을 읽은 경우 
               id.value  => $('#id').val()
               --------
               id.textContent => $('#id').text()
               --------------
               id.innerHTML  => $('#id').html()
               ---------------- $('#id').attr()
     JQUERY => $('#id')
 */
$(function(){
	$('#logBtn').on('click',function(){
		//alert("Hello Jquery!!")
		let id=$('#id').val(); // .val() id가 "id"인 HTML 요소의 값을 가져온다.
		// let id=document.querySelector('#id').value
		if(id.trim()=="")
		{
			$('#id').focus();
			return;
		}
		let pwd=$('#pwd').val();
		// let id=document.querySelector('#id').value
		if(pwd.trim()=="")
		{
			$('#pwd').focus();
			return;
		}
		//$('#frm').submit();
		$.ajax({
			/*
			.ajax() 메서드는 다양한 매개변수를 가지며, 일반적으로는 다음과 같은 옵션을 설정합니다:

				type: 요청의 HTTP 메서드 (GET, POST 등)를 지정합니다.
				url: 요청을 보낼 서버의 URL입니다.
				data: 요청에 포함할 데이터를 지정합니다.
				dataType: 서버에서 받은 응답의 데이터 형식을 지정합니다 (예: "json", "xml").
				success: 요청이 성공적으로 완료되었을 때 실행할 콜백 함수를 지정합니다.
				error: 요청이 실패했을 때 실행할 콜백 함수를 지정합니다.
			*/
			type:'post',
			url:'login_ok.jsp',
			data:{"id":id,"pwd":pwd},
			success:function(result)
			{
				let res=result.trim();
				if(res=='NOID')
				{
					$('#id').val("");
					$('#pwd').val("");
					$('#id').focus();
					$('#print').text("아이디 존재하지 않습니다");
				}
				else if(res==='NOPWD')
				{
					$('#pwd').val("");
					$('#pwd').focus();
					$('#print').text("비밀번호가 틀립니다");
				}
				else
				{
					alert("로그인 성공!");
					location.href="../databoard/list.jsp"
				}
			}
		})
	})
})
</script>

<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Login</h1>
		<div class="row">
			<table class="table">
				<tr>
					<td width=20%>ID</td>
					<td width=80%>
						<input type=text name=id size=15 class="input-sm" id = id>
					</td>
				</tr>
				<tr>
					<td width=20%>Password</td>
					<td width=80%>
						<input type=text name=pwd size=15 class="input-sm" id = pwd>
					</td>
				</tr>
				<tr>
					<td colspan=2 class="text-center">
						<span id=print style="color:red"></span>
					</td>
				</tr>
				<tr>
					<td colspan=2 class="text-center">
					<input type=button class="btn btn-sm btn-danger" value=로그인 id="logBtn">
					<a href="../databoard/list.jsp" class="btn btn-sm btn-success">게시판</a>
					</td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>