<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html> 
<head>
<title>Welcome</title>
</head>
 
<body>
    <h2>Bienvenido, <s:property value="username" />...!</h2>
    
    <s:actionerror />
	<s:form action="mostrarTitulosAction" method="execute">
    <s:textfield name="professorUsername" key="label.nombreProf" size="50" />
    <s:submit method="execute" key="label.insertProfInfo" align="center" />
</s:form>
    
</body>
</html>