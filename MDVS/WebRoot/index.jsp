<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index page</title>
  </head>
  <body>
  	<hr>
	  	<a href="material/material.jsp">Original Add Materials</a><br>
	  	<a href="material/material_1.jsp">New Add Materials</a>
	  	<a href="DTA.jsp">New Add Materials</a>
  	<hr>
	<form action="register.action" method="post">
		Name:<input type="text" name="name" /><br>
		Age:<input type="text" name="age" /><br>
		<input type="submit" value="Register" />
	</form><br><hr>
	<form action="material/query.action" method="post">
		ID:<input type="text" name="id" /><br>
		<input type="submit" value="Submit"/>
	</form>
  </body>
</html>
