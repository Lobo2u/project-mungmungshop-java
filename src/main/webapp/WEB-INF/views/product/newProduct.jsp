	<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"	isELIgnored="false"
	%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%>  
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<meta charset="utf-8">
<title>신상품 목록</title>
</head>
<body>
<div align="left">
<h1 class="display-5 fw-bold">신상품</h1>
</div>
<div align="right">
                    
                                               
                                                <a href="javascript:sort('regdate')">인기상품&nbsp;&nbsp;&nbsp;</a>		<!-- 나중에 참고하기 위해 하이퍼링크 링크 남겨놓음 -->
                                                <a href="javascript:sort('regdate')">신상품&nbsp;&nbsp;&nbsp;</a>                                                                                              
                                                <a href="javascript:sort('price_low')">낮은가격&nbsp;&nbsp;&nbsp;</a>
                                                <a href="javascript:sort('price_hign')">높은가격&nbsp;&nbsp;&nbsp;</a>
                                                
                                                
                                            
</div>
<hr width="100%">
<!-- 첫번째 줄 -->
<div class="row">
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
	   </div>
<!-- 두번째 줄 -->
<div class="row">
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
	   </div>
<!-- 세번째 줄 -->
<div class="row">
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
	   </div>
<!-- 네번째 줄 -->
<div class="row">
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
        <div class="col-md-4" style="display: inline-block; float: left;">
          <div class="card mb-4 shadow-sm" style="cursor: pointer;" onclick="location.href='#';">
            <div class="bd-placeholder-img card-img-top">
            	<img src="resources/image/네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg.jpg" style=" width: 100%; height: 225;"/>
            </div>
            <div class="card-body">
              <p style="font-size: 14px;">네츄럴코어 홀리스틱 베네 M32 멀티프로테인 6kg</p>
              <p style="font-size: 14px;">32000원</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                 
                </div>
                <p style="color: red;">♥ 1825</p>
              </div>
            </div>
          </div>
        </div>
	   </div>
</body>
</html>