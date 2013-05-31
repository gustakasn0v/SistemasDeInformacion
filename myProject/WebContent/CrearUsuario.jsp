<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>CrearUsuario</title>
</head>
 
<body>
    <h2>LLene todo los campos siguientes:</h2>
    
    <s:actionerror />
	<s:form action="CrearUsuario.action" method="post">
    <s:textfield name="nombreUsuario" key="label.nombreUsuario" size="20" />
    <s:textfield name="contrasenia" key="label.contrasenia" size="20" />
    <s:textfield name="nombre" key="label.nombre" size="20" />
    <s:textfield name="eMail" key="label.eMail" size="20" />
    <s:textfield name="cedula" key="label.cedula" size="20" />
    <s:submit method="execute" key="label.crearUsuario" align="center" />
</s:form>
    
</body>
</html>
