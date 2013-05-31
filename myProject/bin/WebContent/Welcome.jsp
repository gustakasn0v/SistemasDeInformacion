<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Welcome</title>
</head>
 
<body>
    <h2>Bienvenido, <s:property value="username" />...!</h2>
    
    <s:actionerror />
	<s:form action="agregarTitulos.action" method="post">
    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
    <s:textfield name="cedulaProf" key="label.cedulaProf" size="50" />
    <s:textfield name="titulo1" key="label.titulo" size="50" />
    <s:textfield name="titulo2" key="label.titulo" size="50" />
    <s:textfield name="titulo3" key="label.titulo" size="50" />
    <s:submit method="execute" key="label.insertProfInfo" align="center" />
</s:form>
    
</body>
</html>