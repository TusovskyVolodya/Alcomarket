
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" href=/resources/css/1.css>
<style>
body{
position:absolute;
  width:100%;
  margin-left: 0;
  background-image: url("/resources/css/bar.jpg");
  background-size:cover;
}
#pages{
background-color: red;
margin-bottom: 100px;
}
</style>
            <div class="page">    
<div class="row">
	<div class="col-md-5">
	<form:form class="form-horizontal" action="/" method="GET" modelAttribute="filter" id="filter">
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
    				<div class="col-sm-12">
      					<button type="submit" class="btn btn-primary">Search</button>
    				</div>
  				</div>
  			
</form:form>
</div>
</div>
<div class="row">
	<div class="col-sm-12 col-xs-12 parent">
		<c:forEach items="${page.content}" var="item">
			<div>
				<img src="/images/item/${item.id}.jpg?version=${item.version}" width="100%">
				<p>${item.item}</p>
				<p>${item.price} грн</p>
				<p>${item.country.country}</p>
				<div>
					<a class="btn btn-danger" href="/buy/${item.id}<custom:allParams/>">Buy</a>
				</div>
			</div>
		</c:forEach>
	</div>
</div>	
	<div class="col-md-4 col-xs-12">
		
			<div class="col-md-6 col-xs-6 text-right">
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
			<div class="row">
			<div class="col-md-6 col-xs-6 text-center">
				<custom:size posibleSizes="1,2,5,10" size="${page.size}" />
			</div>
				</div>
	</div>
	<div class="row text-center" id="pages">
		<custom:pageable page="${page}" cell="<li></li>" container="<ul class='pagination'></ul>" />
	</div>
       </div> 
            

 