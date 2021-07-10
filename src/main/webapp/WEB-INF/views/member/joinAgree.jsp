<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<%
request.setCharacterEncoding("UTF-8");
%>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
	integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
	integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
	crossorigin="anonymous"></script>
<meta charset="utf-8">
<title>이용동의</title>
</head>
<script>
function checkSelectAll()  {
  // 전체 체크박스
  const checkboxes 
    = document.querySelectorAll('input[name="agree"]');
  // 선택된 체크박스
  const checked 
    = document.querySelectorAll('input[name="agree"]:checked');
  // select all 체크박스
  const selectAll 
    = document.querySelector('input[name="selectall"]');
  
  if(checkboxes.length === checked.length)  {
    selectAll.checked = true;
  }else {
    selectAll.checked = false;
  }

}

function selectAll(selectAll)  {
  const checkboxes 
     = document.getElementsByName('agree');
  
  checkboxes.forEach((checkbox) => {
    checkbox.checked = selectAll.checked
  })
}

function fn_agreeChk(){    
	if($("#agree_1").is(":checked") == false){
    	alert("뭉뭉샵 이용약관과 개인정보 수집 및 이용약관을 모두 동의해주세요.");
        return;
    }else if($("#agree_2").is(":checked") == false) {
     	alert("뭉뭉샵 이용약관과 개인정보 수집 및 이용약관을 모두 동의해주세요.");
        return;
    }else {
     	$("#agree_form").submit();
    }
}
</script>
<body>
<form method="GET" id="agree_form" action="${contextPath}/joinMember.do">
	<div align="center" style="margin-top: 20;">
		<input type="checkbox" class="form-check-input"	name="selectall" onclick="selectAll(this)">
		<b>뭉뭉샵 이용약관,개인정보 수집 및 이용에 모두 동의합니다.</b>
	</div>
	<div class="container">
		<div class="col" style="margin-top: 20;">
			<div>
				<div style="text-align: center;">
					<label><input type="checkbox" class="form-check-input"
						 id="agree_1" name="agree" onclick="checkSelectAll()" /><b>뭉뭉샵
							이용약관 동의(필수)</b></label>
				</div>
				<div>
					<textarea name="#" style="resize: none; width: 500px;" cols="30"
						rows="5">이용 약관 동의하십니까(향후추가)</textarea>
					<br>
				</div>
			</div>
			<div style="margin-top: 10;">
				<div style="text-align: center;">
					<label><input type="checkbox" class="form-check-input"
						 id="agree_2" name="agree" onclick="checkSelectAll()" /><b>개인정보 수집 및
							이용약관 동의(필수)</b></label>
				</div>
				<div>
					<textarea name="#" style="resize: none; width: 500px;" cols="30"
						rows="5">개인정보 수집 및 이용에 동의 하십니까(향후추가)</textarea>
					<br>
				</div>
			</div>
		</div>

		<div style="margin-top: 10;">
			<button type="button" class="btn btn-outline-secondary btn-lg px-4" onclick="javascript: history.back();">취소</button>
			<button type="button" class="btn btn-primary btn-lg px-4 gap-3" onclick="fn_agreeChk();">다음</button>
		</div>
	</div>
</form>
</body>
</html>
