<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
        <meta charset="utf-8">
  <nav class="navbar navbar-inverse navbar-fixed-top" id="nav" >
                <div class="container-fluid-1">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#one" area-expanded="false">
                            <span class="sr-only">Navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                       <a class="navbar-brand" href=""  style="padding:0 15px;">
                            <img class="img-thumbnail" width="145" src="/resources/img/iqSIfPokz3A.jpg">
                        </a>
                
                    </div>
                    <div class="collapse navbar-collapse" id="one">
                        <ul class="nav navbar-nav">
                            <c:forEach items="${categories}" var="category">
		<li><a href="/category/${category.id}">${category.category}</a></li>
	</c:forEach>
                        </ul>

                        <ul class="nav navbar-nav navbar-right">
                         <div class="pull-right">
    <ul class="nav navbar-nav">
    
    	<security:authorize access="!isAuthenticated()">
	    	<li><a href="/login">Login</a></li>
	    	<li><a href="/registration">Registration</a></li>
    	</security:authorize>
    	<security:authorize access="isAuthenticated()">
    	<li><a href="">Wellcome, <security:authentication property="principal.username"/></a>  </li> 
	    	<li><a href="/basketUser" class="btn btn-primary cart">Корзина<span class="badge">Basket ${user.count}</span></a></li>
	    	<li> <form:form class="navbar-form navbar-right" action="/logout" method="POST">
	                       <button class="btn-default" >Exit</button>
	                    </form:form></li>
    	</security:authorize>
    	<security:authorize access="hasRole('ROLE_ADMIN')">
    	<li><a href="/admin">ADMIN</a></li>
    	</security:authorize>
    	
    </ul>
    </div>   
                        </ul> 
                    </div>
                </div>
            </nav>