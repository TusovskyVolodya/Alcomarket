<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="row">
	<div class="col-sm-12 col-xs-12">
	<div class="row">	
	
	<div class="col-md-4 col-xs-4"></div>
	<div class="col-md-4 col-xs-4">Назва товару</div>
	<div class="col-md-4 col-xs-4">Ціна товару </div>
	</div>
	<c:set var="s" value="0"></c:set>	
	<c:forEach items="${user.items}" var="item" >
	<div class="row">
	<div class="col-md-4 col-xs-4">
	<img class="img-rounded" width="25%" src="/images/item/${item.id}.jpg" >
	</div>
	<div class="col-md-4 col-xs-4">
	${item.item}
	</div>
	<div class="col-md-4 col-xs-4">
	${item.price}
	<c:set var="s" value="${s+item.price}"></c:set>
	</div>
	<div class="col-md-1"><a href="/basket/deleteItem/${item.id}"><button class="btn btn-danger">Delete</button></a></div>
	</div>
	</c:forEach>
<div class="col-md-8 col-xs-8">
<h3>загальна сума замовлення</h3>
</div>
<div class="col-md-4 col-xs-4">
<h3>${s}</h3>
</div>
		 
		
	</div>
</div>   