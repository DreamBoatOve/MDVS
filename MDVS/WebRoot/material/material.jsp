<%@ page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Add Material</title>
		<script type="text/javascript" src="../js/JQuery/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			function check()
			{
				$("#showArea").hide();
				//指定向JSONExample发送请求，将id为form2的表单所包含的表单控件转换为请求参数
				$.post("JSONExample",$("form2").serializeArray(),
						//指定回调函数
						function(data,statusText)
						{
							for(var d in data.length)
							{
								$("#showArea").append
							}
						}
					  );
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
		<s:form id="form2" action="../material/findMaterialNames.action" method="post">
			<input type="button" value="Show materials" onclick="check();" />
			<div id="showArea"></div>
		</s:form>
	</body>
</html>