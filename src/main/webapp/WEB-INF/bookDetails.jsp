<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
	<!-- YOUR own local CSS -->
	<link rel="stylesheet" href="/css/main.css"/>
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="d-flex flex-column mb-3 p-2 container h-100">
		<div class='d-flex justify-content-between'>
			<h1 ><c:out value="${book.title}"> </c:out></h1>
			<a href="/home"> Back to shelves </a>
		</div>
	
		<h2>
			<c:out  value="${book.user.name}" ></c:out> 
			read <c:out value="${book.title}"></c:out> 
			by <c:out value="${book.author}"> </c:out>
		</h2>
	
		<h3> Here are <c:out value="${book.user.name}" ></c:out> thoughts </h3>
		
		<div class=" border-top border-bottom  ">
			<h7>  <c:out value="${book.thoughts}" ></c:out></h7>
		</div>
		
	</div>
	
	
	
</body>
</html>