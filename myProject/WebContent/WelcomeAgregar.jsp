<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html> 
<head>
<title>Welcome</title>
</head>
 
<body>
    <h2>Bienvenido, <%= session.getAttribute( "username" ) %>...!</h2>
    
    <s:url id="url" action="listTitulo">
	</s:url>
	<s:a href="%{url}">Modificar títulos académicos</s:a>

    
</body>
</html>