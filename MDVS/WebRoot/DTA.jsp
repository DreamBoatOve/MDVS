<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
		<form action="highThroughput/restoreFile.action" method="post" enctype="multipart/form-data">
			<h1>添加材料-服役-测试-高通量组合实验</h1>
				实验样品被划分为：
				<input type="number" name="row" /> 行，<input type="number" name="column" /> 列
				<input type="submit" value="提交"/>
		</form><br>
		<form action="EIS/addEIS.action" method="post" enctype="multipart/form-data">
			上传EIS实验文件：<input type="file" name="EISFile" />
			<input type="submit" value="提交"/>
		</form><br>
		<form action="PD/addPD.action" method="post" enctype="multipart/form-data">
			上传PD实验文件：<input type="file" name="PDFile" />
			<input type="submit" value="提交"/>
		</form><br>
	</body>
</html>