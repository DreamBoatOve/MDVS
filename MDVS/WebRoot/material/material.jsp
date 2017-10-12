<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Add Material</title>
	</head>
	<body>
		<form action="addMaterial.action" method="post">
			Material Name:
				<input type="text" name="materialName" />
				<br />
			Color:
				<input type="radio" name="color" value="b" />Black
				<input type="radio" name="color" value="c" />Colorful
				<br/>
			Reserves:
				<input type="radio" name="reserves" value="c" />Common		
				<input type="radio" name="reserves" value="r" />Rare
				<br />
			Density:
				<input type="radio" name="density" value="l" />Light
				<input type="radio" name="density" value="h" />Heavy
				<br />
			<input type="submit" value="Submit" /> <input type="reset" value="Reset" />
		</form>
	</body>
</html>