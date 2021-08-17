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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<meta charset="utf-8">
<title>검색 목록</title>
</head>
<script>

	//이전 버튼 이벤트
	function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		
		var searchWord = "${searchWord}";
		
		var url = "${contextPath}/product/searchProducts.do?searchWord=" + searchWord;
		
		url = url + "&page=" + page;
		url = url + "&range=" + range;

		location.href = url;
		
}

	//페이지 번호 클릭
	function fn_pagination(page, range, rangeSize, searchType, keyword) {
		var searchWord = "${searchWord}";
		
		var url = "${contextPath}/product/searchProducts.do?searchWord=" + searchWord;
		
		url = url + "&page=" + page;
		url = url + "&range=" + range;

		location.href = url;	
	}

	//다음 버튼 이벤트
	function fn_next(page, range, rangeSize) {

		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;
		
		var searchWord = "${searchWord}";
		
		var url = "${contextPath}/product/searchProducts.do?searchWord=" + searchWord;
		
		url = url + "&page=" + page;
		url = url + "&range=" + range;

		location.href = url;
	}
</script>
<style>
	.product{
	    cursor: pointer; 
	    width: 330px; 
	    height: 400px;
	    margin-right: auto;
	}
</style>
<body>
<div class="container">
	<div align="left">
		<c:choose>
			<c:when test="${searchWord.equals('null')}">
				<h4 style="display:inline-block;"><b>''</b></h4><h5 style="display:inline-block;">에 대한 검색 결과</h5>
			</c:when>
			<c:otherwise>
				<h4 style="display:inline-block;"><b>'${searchWord}'</b></h4><h5 style="display:inline-block;">에 대한 검색 결과</h5>
			</c:otherwise>
		</c:choose>
	</div>
	<hr width="100%">
	<div>
		<c:if test="${products.size() == 0}">
			<div style="margin-top: 300px;">
				<h3><b>검색 결과가 없습니다.</b></h3>
			</div>	
		</c:if>
		<div class="col">
			<div class="row" >
			<c:forEach items="${products}" var="products">
	            <div class="product">
	                <div class="bd-placeholder-img card-img-top">
	                <a href="${contextPath}/product/getProduct.do?p_code=${products.p_code}">
	                    <img
	                        src="${contextPath}/download?imageFileName=${products.p_imageFileName}"
	                        style="width: 50%; height: 225;" alt="상품 이미지" />
	                </a>
	                </div>
	                <div class="card-body">
	                   
	                    <p style="font-size: 14px;">
	                    <a href="${contextPath}/product/getProduct.do?p_code=${products.p_code}">${products.p_name}</a>
	                    </p>
	        
	                    <p style="font-size: 14px;">
	                     <a href="${contextPath}/product/getProduct.do?p_code=${products.p_code}">
	                        <b><fmt:formatNumber value="${products.p_price }"
	                            pattern="###,###,###" />
	                        </b>원
	                     </a>
	                    </p>
	                    <div class="d-flex justify-content-between align-items-center">
	                        <div class="btn-group"></div>
	                        <p style="color: red;">♥ ${products.p_loves}</p>
	                    </div>
	                </div>
	            </div>
	            </c:forEach>
			</div>
		</div>
	
	</div>
	<!-- pagination{s} -->
	<div style="">
		<ul class="pagination" style="width: 0%; justify-content: center;">
			<c:if test="${pagination.prev}">
				<li class="page-item">
					<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}')">Previous</a>
				</li>
			</c:if>
			<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
				<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
					<a class="page-link" href="#" onClick="fn_pagination('${idx}', '${pagination.range}', '${pagination.rangeSize}')"> ${idx} </a>
				</li>
			</c:forEach>
			<c:if test="${pagination.next}">
				<li class="page-item">
					<a class="page-link" href="#" onClick="fn_next('${pagination.range}', '${pagination.range}', '${pagination.rangeSize}')" >Next</a>
				</li>
			</c:if>
		</ul>
	</div>
	<!-- pagination{e} -->
</div>
</body>
</html>