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

	<h1>Listar información del Profesor</h1>
	
	<h3>Títulos</h3>
	<ul>
		<s:iterator value="titulos">	
			<li><s:property/></li>
		</s:iterator>
	</ul>
	
	<h6>Eliminar, insertar modificar un título:</h6>
	<s:actionerror />
	<s:form action="insertarTituloAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:textfield name="cedulaProf" key="label.cedulaProf" size="50" />
	    <s:textfield name="titulo1" key="label.titulo" size="50" />
	    <s:submit method="execute" key="label.insertProfInfo" align="center" />
	</s:form>
	
	<s:actionerror />
	<s:form action="eliminarTituloAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:textfield name="cedulaProf" key="label.cedulaProf" size="50" />
	    <s:textfield name="titulo1" key="label.titulo" size="50" />
	    <s:submit method="execute" key="label.delete" align="center" />
	</s:form>
	
    <s:actionerror />
	<s:form action="actualizarTituloAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:textfield name="cedulaProf" key="label.cedulaProf" size="50" />
	    <s:textfield name="titulo1" key="label.titulo" size="50" />
	    <s:textfield name="titulo2" key="label.newTitulo" size="50" />
	    <s:submit method="execute" key="label.actualizar" align="center" />
	</s:form>
	
	<h3>Material de apoyo</h3>

	<ul>
		<s:iterator value="materialApoyo">	
			<li><s:property/></li>
		</s:iterator>
	</ul>
	
	<h6>Eliminar o modificar un material de apoyo:</h6>
	
</body>
</html>