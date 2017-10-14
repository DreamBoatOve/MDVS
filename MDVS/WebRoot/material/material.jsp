<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Add Material</title>
		<script type="text/javascript" src="../js/JQuery/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			var materialNames_JA_Str = <%=request.getParameter("materialNames_JA_Str")%>;
			alert("materialNames_JA_Str: "+materialNames_JA_Str);
			var materialNames_Json = eval('('+materialNames_JA_Str+')');
			function checkMaterialNames()
			{
				for(i = 0;i<materialNames_Json.length;i++)
				{
					alert("material Name: "+materialNames_Json[i]);
				}
			}
		</script>
	</head>
	<body>
		<form action="../material/addMaterial.action" method="post">
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
			Experiment Scale:
				<input type="radio" name="scale" value="c" />Convention
				<input type="radio" name="scale" value="m" />Microcell
				<br />
			<input type="submit" value="Submit" /> <input type="reset" value="Reset" />
		</form><hr />
		<form action="../material/findMaterialNames.action" method="post">
			<input type="button" value="Check material names" onclick="checkMaterialNames()"/>
			<span id="a1"></span>
		</form>
	</body>
</html>