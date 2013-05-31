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
	Tu cedula es, <%= session.getAttribute( "cedula" ) %>
	<h1>Listar información del Profesor</h1>
	
	<h3>Títulos</h3>
	<s:iterator value="titulos">	
		<li><s:property/></li>
	</s:iterator>
	
	<h6>Eliminar, insertar modificar un título:</h6>
	<s:actionerror />
	<s:form action="insertarTituloAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:hidden name="cedulaProf" value="%{#session.cedula}" />
	    <s:textfield name="titulo1" key="label.titulo" size="50" />
	    <s:submit method="execute" key="label.insertProfInfo" align="center" />
	</s:form>
	
	<s:actionerror />
	<s:form action="eliminarTituloAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:hidden name="cedulaProf" value="%{#session.cedula}" />
	    <s:textfield name="titulo1" key="label.titulo" size="50" />
	    <s:submit method="execute" key="label.delete" align="center" />
	</s:form>
	
    <s:actionerror />
	<s:form action="actualizarTituloAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:hidden name="cedulaProf" value="%{#session.cedula}" />
	    <s:textfield name="titulo1" key="label.titulo" size="50" />
	    <s:textfield name="titulo2" key="label.newTitulo" size="50" />
	    <s:submit method="execute" key="label.actualizar" align="center" />
	</s:form>
	
	<h3>Material de Apoyo</h3>
	<s:iterator value="materialApoyo">	
		<li><s:property/></li>
	</s:iterator>
	
	<s:actionerror />
	<s:form action="insertarMaterialAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:hidden name="cedulaProf" value="%{#session.cedula}" />
	    <s:textfield name="material1" key="label.material" size="50" />
	    <s:submit method="execute" key="label.insertProfInfo" align="center" />
	</s:form>
	
	<s:actionerror />
	<s:form action="eliminarMaterialAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:hidden name="cedulaProf" value="%{#session.cedula}" />
	    <s:textfield name="material1" key="label.material" size="50" />
	    <s:submit method="execute" key="label.delete" align="center" />
	</s:form>
	
    <s:actionerror />
	<s:form action="actualizarMaterialAction" method="execute">
	    <s:textfield name="nombreProf" key="label.nombreProf" size="50" />
	    <s:hidden name="cedulaProf" value="%{#session.cedula}" />
	    <s:textfield name="material1" key="label.material" size="50" />
	    <s:textfield name="material2" key="label.newMaterial" size="50" />
	    <s:submit method="execute" key="label.actualizar" align="center" />
	</s:form>
	
	<h6>Eliminar o modificar un material de apoyo:</h6>
	
</body>
</html>