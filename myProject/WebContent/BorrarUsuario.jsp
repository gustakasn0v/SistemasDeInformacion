<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>BorrarUsuario</title>
</head>
 
<body>
    <h2>Introduzca el nombre de usuario que desea eliminar:</h2>
    
    <s:actionerror />
	<s:form action="BorrarUsuario.action" method="post">
    <s:textfield name="nombreUsuario" key="label.nombreUsuario" size="20" />
    <s:submit method="execute" key="label.borrarUsuario" align="center" />
</s:form>
    
</body>
</html>