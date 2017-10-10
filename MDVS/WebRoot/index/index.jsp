<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>index page</title>
  </head>
  <body>
	<form action="mdvs/register.action" method="post">
		Name:<input type="text" name="name" /><br>
		Age:<input type="text" name="age" /><br>
		<input type="submit" value="Register" />
	</form><br><hr>
	<form action="test/query.action" method="post">
		ID:<input type="text" name="id" /><br>
		<input type="submit" value="Submit"/>
	</form>
  </body>
</html>
