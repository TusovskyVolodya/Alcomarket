<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<style>
	#filter>.form-group>.col-sm-12>span{
		display: block;
	}
</style>
<div class="row">
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="/admin/category">Category</a></li>
					<li ><a href="/admin/country">Country</a><span
						class="sr-only">(current)</span></li>
					<li><a href="/admin/kind">Kind</a></li>
					<li><a href="/admin/giftBox">GiftBox</a></li>
					<li><a href="/admin/brand">Brand</a></li>
					<li class="active"><a href="/admin/item">Item</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>

<div class="row">
	<div class="col-md-5">
	<form:form class="form-horizontal" action="/admin/item" method="GET" modelAttribute="filter" id="filter">
				<custom:hiddenInputs excludeParams="search, minPrice, maxPrice, brandIds, countryIds" excludeParamsPrefix="specDigitFilters"/>
				<div class="form-group">
					<div class="col-sm-6">
	      				<form:input type="text" class="form-control" path="search" placeholder="Search"/>
	    			</div>
				</div>
				<div class="form-group">
				<div class="col-sm-6 col-xs-6">
					<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="minPrice" placeholder="Min price"/>
	    			</div>
	    			<div class="col-sm-6 col-xs-6">
	      				<form:input type="text" class="form-control" path="maxPrice" placeholder="Max price"/>
	    			</div>
				</div>
				</div>
				<div class="form-group">
    					<label for="country" class="col-sm-2 control-label">Category</label>
    					<div class="col-sm-4">
      						<form:select class="form-control" path="categoryIds" id="category" items="${categories}" itemValue="id" itemLabel="category"/>
    					</div>
  					</div>
				<div class="form-group">
    					<label for="country" class="col-sm-2 control-label">Country</label>
    					<div class="col-sm-4">
      						<form:select class="form-control" path="countryIds" id="country" items="${countries}" itemValue="id" itemLabel="country"/>
    					</div>
  					</div>
  					<div class="form-group">
    					<label for="country" class="col-sm-2 control-label">Brand</label>
    					<div class="col-sm-4">
      						<form:select class="form-control" path="brandIds" id="brand" items="${brands}" itemValue="id" itemLabel="brand"/>
    					</div>
  					</div>
  					<div class="form-group">
  					<label for="country" class="col-sm-2 control-label">Kind</label>
					<div class="col-sm-12">
						<form:checkboxes items="${kinds}" path="kindIds" itemLabel="kind" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
				<label for="country" class="col-sm-2 control-label">GiftBox</label>
					<div class="col-sm-12">
						<form:checkboxes items="${giftBoxs}" path="giftBoxIds" itemLabel="giftBox" itemValue="id"/>
					</div>
				</div>
				<div class="form-group">
    				<div class="col-sm-12">
      					<button type="submit" class="btn btn-primary">Search</button>
    				</div>
  				</div>
			</form:form>
	</div>
	
			<div class="col-md-6 col-xs-6">
				<form:form class="form-horizontal" action="/admin/item"
					method="POST" modelAttribute="item" enctype="multipart/form-data">
					<form:errors path="item"/>
					<div class="form-group">
						<label for="item" class="col-sm-2"><form:errors
								path="item" /></label>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">Item</label>
						<div class="col-sm-11">
							<form:input type="text" class="form-control" path="item"
								id="item" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">Category</label>
						<div class="col-sm-5">
							<form:select class="form-control" path="category"
								itemLabel="category" itemValue="id" items="${categories}" />
						</div>
						<label class="col-sm-1 control-label">Country</label>
						<div class="col-sm-5">
							<form:select class="form-control" path="country"
								itemLabel="country" itemValue="id" items="${countries}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">Brand</label>
						<div class="col-sm-5">
							<form:select class="form-control" path="brand"
								itemLabel="brand" itemValue="id" items="${brands}" />
						</div>
						<label class="col-sm-1 control-label">Kind</label>
						<div class="col-sm-5">
							<form:select class="form-control" path="kind"
								itemLabel="kind" itemValue="id" items="${kinds}" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">GiftBox</label>
						<div class="col-sm-5">
							<form:select class="form-control" path="giftBox"
								itemLabel="giftBox" itemValue="id" items="${giftBoxs}" />
						</div>
						
  						<label class="col-sm-1 control-label">Price</label>
  						<div class="col-sm-5">
  						<label for="price" class="col-sm-offset-2 col-sm-10"><form:errors path="price"/></label>
  							<form:input id="price" path="price" class="form-control"/>
  						</div>
  						<form:errors path="*"/>
  						</div>
					<div class="form-group">
						
					
  						<label class="col-sm-1 control-label">Capasity</label>
  						<div class="col-sm-5">
  						<label for="capasity" class="col-sm-offset-2 col-sm-10"><form:errors path="capasity"/></label>
  							<form:input id="capasity" path="capasity" class="form-control"/>
  						</div>
  						<form:errors path="*"/>
  						
					
						
  					
  						<label class="col-sm-1 control-label">Eduranse</label>
  						<div class="col-sm-5">
  						<label for="eduranse" class="col-sm-offset-2 col-sm-10"><form:errors path="eduranse"/></label>
  							<form:input id="eduranse" path="eduranse" class="form-control"/>
  						</div>
  						<form:errors path="*"/>
  						</div>
  						<div class="form-group">
  						<div class="col-sm-offset-2 col-sm-10">
		  					<label class="btn btn-default btn-file">
		        				Browse <input type="file" name="file" style="display: none;">
		    				</label>
	    				</div>
    				</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">Create</button>
						</div>
					</div>
				</form:form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-2 col-xs-2"><h3>Image</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Item name</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Item price</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Item capasity</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Country</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Update</h3></div>
			<div class="col-md-1 col-xs-1"><h3>Delete</h3></div>
		</div>
			<c:forEach items="${page.content}" var="item">
				<div class="row">
					<div class="col-md-2 col-xs-2"><img class="img-rounded" width="100%" src="/images/item/${item.id}.jpg?version=${item.version}"></div>
					<div class="col-md-1 col-xs-1">${item.item}</div>
					<div class="col-md-1 col-xs-1">${item.price}</div>
					<div class="col-md-1 col-xs-1">${item.capasity}</div>
					<div class="col-md-1 col-xs-1">${item.country.country}</div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-warning" href="/admin/item/update/${item.id}<custom:allParams/>">update</a></div>
					<div class="col-md-1 col-xs-1"><a class="btn btn-danger" href="/admin/item/delete/${item.id}<custom:allParams/>">delete</a></div>
				</div>
			</c:forEach>
	<div class="col-md-2 col-xs-12">
		<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<div class="dropdown">
					<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Sort <span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<custom:sort innerHtml="Name asc" paramValue="item"/>
						<custom:sort innerHtml="Name desc" paramValue="item,desc"/>
						<custom:sort innerHtml="Price asc" paramValue="price"/>
						<custom:sort innerHtml="Price asc" paramValue="price,desc"/>
					</ul>
				</div>
			</div>
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
		</div>
	</div>
<div class="row">
	<div class="col-md-12 col-xs-12 text-center">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
</div>