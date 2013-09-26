<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="estilo.css"/>
<html> 
<head>
<title>Welcome</title>
</head>
 
<body>

<div id="body-content">
	<div id="banner"></div>
    <div id="sidebarL">
	    <s:url id="url" action="listTitulo">
		</s:url>
		<s:a href="%{url}">Modificar títulos académicos</s:a> <br/><br/>
		
		<s:url id="url" action="listMaterialApoyo">
		</s:url>
		<s:a href="%{url}">Modificar materiales de apoyo</s:a>
	</div>
	<div id="sidebarR"></div>
    <h4>Bienvenido, <%= session.getAttribute( "username" ) %></h4> 
    <h5>Elija una opcion del menu a su izquierda</h5>
    

</div>



</body>
</html>