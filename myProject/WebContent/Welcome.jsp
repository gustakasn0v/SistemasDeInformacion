<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:actionerror />
	<s:form action="mostrarTitulos.action" method="post">
    <s:textfield name="nombreusuario" key="label.nombreProf" size="50" />
    <s:textfield name="cedulaProf" key="label.cedulaProf" size="50" />
    <s:textfield name="titulo1" key="label.titulo" size="50" />
    <s:textfield name="titulo2" key="label.titulo" size="50" />
    <s:textfield name="titulo3" key="label.titulo" size="50" />
    <s:submit method="execute" key="label.insertProfInfo" align="center" />
</s:form>

</body>
</html>