<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="estilo.css"/>
<html>
<head>
<title>Modificar material de apoyo del profesor</title>
</head>
<body>
<div class="container_3">
	<div class="grid_3"><div class="banner"></div><div class="blue_bar">Bienvenido, <%= session.getAttribute( "username" ) %> </div></div>
    <div class="grid_1">
	   	<p></p>
	   	
	    <s:url id="url" action="modMaterial"></s:url>
		<s:a href="%{url}">Agregar material de apoyo</s:a><br/><br/>
		
	    <s:url id="url" action="modTitulo"></s:url>
		<s:a href="%{url}">Agregar títulos académicos</s:a><br/><br/>
	   	
	    <s:url id="url" action="listTitulo"></s:url>
		<s:a href="%{url}">Mostar/Modificar títulos académicos</s:a><br/><br/>
		
		<s:url id="url" action="listMaterialApoyo"></s:url>
		<s:a href="%{url}">Mostrar/Modificar material de apoyo</s:a><br/><br/>

		<s:url id="url" action="listMateria"></s:url>
		<s:a href="%{url}">Mostrar/Modificar materias modificadas</s:a><br/><br/>
					
		<s:url id="url" action="logout"></s:url>
		<s:a href="%{url}">Cerrar sesión</s:a>
	</div>
	
	<div class="grid_2">
	<p class="blue">En esta sección, usted podrá agregar y editar las materias que ha dictado</p>
		<div class="center">
			<s:form action="saveOrUpdateMateria">
				<s:push value="materia">
					<s:hidden name='id'/>
					<s:textfield name="codigo" label="Codigo" />
					<s:textfield name="nombre" label="Nombre" />
					<s:submit />
				</s:push>
			</s:form>
		</div>
		<s:if test="materiaList.size() > 0">
			<div class="content">
			<table class="tabla">
				<tr class="even">
					<th class="tabla">Codigo</th>
					<th class="tabla">Nombre</th>
					<th class="tabla">Editar</th>
					<th class="tabla">Borrar</th>
				</tr>
				<s:iterator value="materiaList" status="materiaStatus">
					<tr
						class="<s:if test="#materiaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td class="tabla"><s:property value="codigo" /></td>
						<td class="tabla"><s:property value="nombre" /></td>
						<td class="tabla"><s:url id="editURL" action="editMateria">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}">Editar</s:a></td>
						<td class="tabla"><s:url id="deleteURL" action="deleteMateria">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
					</tr>
				</s:iterator>
			</table>
			</div>
		</s:if>
	</div>
</body>
</html>