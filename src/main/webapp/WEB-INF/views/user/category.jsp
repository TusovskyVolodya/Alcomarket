<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<h2>Category: ${category.category}</h2>
<div class="row" id="item">
<div class="row" id="item">
             <div class="col-md-6"  id="item">
			<div class="col-md-2 col-xs-2"><h3>item</h3></div>
			<div class="col-md-2 col-xs-2"><h3>name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>price</h3></div>
			<div class="col-md-2 col-xs-2"><h3>country</h3></div>
			</div>
			
			  <div class="col-md-6"  id="item">
			<div class="col-md-2 col-xs-2"><h3>item</h3></div>
			<div class="col-md-2 col-xs-2"><h3>name</h3></div>
			<div class="col-md-2 col-xs-2"><h3>price</h3></div>
			<div class="col-md-2 col-xs-2"><h3>country</h3></div>
			</div>
			<div class="row" id="item"></div>
		</div>

			<c:forEach items="${items}" var="item">
				<div class="col-md-6"  id="item">
					<div class="col-md-2 col-xs-2"><img class="img-rounded" width="100%" src="/images/item/${item.id}.jpg"></div>
					<div class="col-md-2 col-xs-2">${item.item}</div>
					<div class="col-md-2 col-xs-2">${item.price}</div>
					<div class="col-md-2 col-xs-2">${item.country.country}</div>
					<a class="btn btn-danger" href="/buy/${item.id}">Buy</a>
				</div>
			</c:forEach>
					</div>	
					
<c:if test="${empty items}">
	<h3>Category is empty</h3>
</c:if>