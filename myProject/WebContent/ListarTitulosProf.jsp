<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Títulos</title>
</head>
<body>

	<h1>Lista de los Títulos del profesor</h1>
	<ul>
		<s:iterator value="titulos">	
			<li><s:property/></li>
		</s:iterator>
	</ul>

</body>
</html>