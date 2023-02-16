<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<!-- For any Bootstrap that uses JS or jQuery-->
	<script src="/webjars/jquery/jquery.min.js"></script>
	<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<head>
<title>Login Page </title>
</head>
  <style>
    .form-container {
      background-color: #fff;
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.1);
    }
  </style>
</head>

<body class="bg-light ">
 
 <div class="container h-100">
      <div class="row h-100 align-items-center">
        <div class="col-md-6 mx-auto">
			<h1 class="text-info"> Book Club  </h1>
			<p> A place for friends to share thoughts on books. </p>


			<div class="form-group">
				<form:form action="/register" method="post" modelAttribute="newUser" class="form-container">
					<h1 class="text-primary"> Register </h1>
						<div class="form-group">
						
						   	<p>
						        <form:label path="name">Name</form:label>
						        <form:errors path="name"/>
						        <form:input class="form-control" path="name"/>
						    </p>
						    <p>
						        <form:label path="userName">User Name</form:label>
						        <form:errors path="userName"/>
						        <form:input class="form-control" path="userName"/>
						    </p>
						    <p>
						        <form:label path="email">Email</form:label>
						        <form:errors path="email"/>
						        <form:input class="form-control" path="email"/>
						    </p>
						    <p>
						        <form:label path="password">Password</form:label>
						        <form:errors path="password"/>
						        <form:input type="password" class="form-control" path="password"/>
						    </p>
						    <p>
						        <form:label path="confirm">Confirm password</form:label>
						        <form:errors path="confirm"/>
						        <form:input type="password" class="form-control" path="confirm"/>
						    </p> 
					  </div>
					  <input type="submit" class="btn btn-primary btn-block" value="Register"/>
				</form:form>
			</div>
			
				<br> 
	
			<form:form class="form-container" action="/login" method="post" modelAttribute="newLogin">
				<h3 class="text-center">Login</h3>
				    <p>
				        <form:label path="email">Email</form:label>
				        <form:errors path="email"/>
				        <form:input class="form-control" path="email"/>
				     </p>
				     <p>
				        <form:label path="password">Password</form:label>
				        <form:errors path="password"/>
				        <form:input type = "password" class="form-control" path="password"/>
				     </p>
				
				    <input type="submit"  class="btn btn-primary btn-block" value="Login"/>
				</form:form>
		</div>
 	</div>
 </div>
</body>
</html>