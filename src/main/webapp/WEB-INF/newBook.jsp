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
	
 <div class="container h-100">
      <div class="row h-100 align-items-center">
        <div class="col-md-6 mx-auto">
			<h1 class="text-info"> Add a book to your shelf  </h1>
			<div class="form-group">
			<form:form action="/addBook/${user.id}" method="post" modelAttribute="book" class="form-container">
					<h1 class="text-primary"> Add Book </h1>
						<div class="form-group">
						   	<p>
						        <form:label path="title">Title</form:label>
						        <form:errors path="title"/>
						        <form:input class="form-control" path="title"/>
						    </p>
						    <p>
						        <form:label path="author">Author</form:label>
						        <form:errors path="author"/>
						        <form:input class="form-control" path="author"/>
						    </p>
						    <p>
						        <form:label path="thoughts">My thoughts</form:label>
						        <form:errors path="thoughts"/>
						        <form:input class="form-control" path="thoughts"/>
						    </p>
						
					  </div>
					  <input type="submit" class="btn btn-primary btn-block"/>
				</form:form> 
			
			</div>
		</div>
	</div>
</div>
</body>
</html>