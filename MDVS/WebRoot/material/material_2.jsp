<%@ page import="org.springframework.web.context.request.SessionScope"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Add Material 1</title>
		<script type="text/javascript" src="../js/JQuery/jquery-3.2.1.js"></script>
		<script type="text/javascript">
			function check()
			{
				alert("invoke check function");
				$("#showMaterials").hide();
				//指定向JSONExample发送请求，将id为form2的表单所包含的表单控件转换为请求参数
				$.post("findMaterialNames",$("form2").serializeArray(),
						/*
						* 指定回调函数
						* data代表服务器响应，此处只是把服务器响应显示出来
						* statusText响应状态success/error
						*/
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
						"json"
					  );
			}
			function addOption()
			{
				var row = areaForm.row.value;
				var col = areaForm.col.value;
				for (var i = 0; i < row; i++)
				{					
					$("#selectedRow").append("<option value = "+(i+1)+">"+(i+1)+"<option>");
				}
				for(var i = 0; i < col; i++)
				{
					$("#selectedCol").append("<option value = "+(i+1)+">"+(i+1)+"<option>");
				}
			}
		</script>
	</head>
	<body>
		<form action="../material/addMaterial.action" method="post">
			<h1>添加材料</h1>
				材料名称(Material Name):
					<input type="text" name="materialName" />
					<br />                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                       
				材料颜色(Color):
					<input type="radio" name="color" value="b" />Black
					<input type="radio" name="color" value="c" />Colorful
					<br/>
				材料储量(Reserves):
					<input type="radio" name="reserves" value="c" />Common		
					<input type="radio" name="reserves" value="r" />Rare
					<br />
				材料密度(Density):
					<input type="radio" name="density" value="l" />Light
					<input type="radio" name="density" value="h" />Heavy
					<br />
				实验区域范围(Experiment Scale):
					<input type="radio" name="scale" value="c" />Convention
					<input type="radio" name="scale" value="m" />Microcell
					<br />

			<h2>添加材料-服役</h2>
			<h3>添加材料-服役-测试</h3>
			<h4>添加材料-服役-测试-高通量组合实验</h4>
			上传EIS实验文件：
				<input type="file" name="" /><br>				
			上传PD实验文件：
				<input type="file" name="" />
			<h5>添加材料-服役-测试-高通量组合实验</h5>
			<h6></h6>
			<input type="submit" value="Submit" /> <input type="reset" value="Reset" />
		</form>
	</body>
</html>