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
				alert("invoke check function");
				$("#showArea").hide();
				//指定向JSONExample发送请求，将id为form2的表单所包含的表单控件转换为请求参数
				$.post("findMaterialNames",$("form2").serializeArray(),
						//指定回调函数
						//data代表服务器响应，此处只是把服务器响应显示出来
/* 						function(data,s)
						{
							alert(data);
							alert(s);
						}, */
						function(data,statusText)
						{
							alert(data);
							alert(statusText);
							var jo = eval('('+data+')');
							for(var d in jo)
							{
								$("#showArea").append(d+"-->"+jo[d]+"<br />");
							}
							$("#showArea").show(600);
						},
/* 						function(data,statusText)
						{
							alert(data);
							alert(statusText);
							for(var d in data)
							{
								$("#showArea").append(d+"-->"+data[d]+"<br />");
							}
							$("#showArea").show(600);
						}, */
						"json"
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