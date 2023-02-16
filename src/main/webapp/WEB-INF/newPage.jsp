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
<body class='bg-light'>
<div>
 <div class="container">

	<h1> Welcome, <c:out value="${user.name}"> </c:out> </h1>
	<div class="d-flex justify-content-between bd-highlight mb-2">
		<h2> Books from everyone's shelves </h2>
		<div class="d-flex flex-column mb-3 ">
			<a href="/"> Logout </a>
			<a href="book/new"> Add to my shelf!</a>
		</div>
	</div>
	<table class="table table-striped table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">ID</th>
	      <th scope="col">Title</th>
	      <th scope="col">Author Name</th>
	      <th scope="col">Posted By</th>
	    </tr>
	  </thead>
	  <tbody>
	     <c:forEach var="booksUsers" items="${books}"> 
	    <tr>
	      <th scope="row"><c:out value = "${booksUsers.user.id}"/></th>
	      <td><a href="/books/${booksUsers.id}"><c:out value = "${booksUsers.title}"/></a></td>
	      <td><c:out value = "${booksUsers.author}"/></td>
	      <td><c:out value = "${booksUsers.user.name}"/></td>
	    </tr>
	     </c:forEach>
	  </tbody>
	</table>
</div>
</div>
</body>
</html>