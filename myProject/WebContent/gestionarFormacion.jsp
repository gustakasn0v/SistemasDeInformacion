<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="estilo.css"/>
<html>
<head>
<title>Bienvenida profesor</title>
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
			
			<s:url id="url" action="logout"></s:url>
			<s:a href="%{url}">Cerrar sesión</s:a>
		</div>
		<div class="grid_2">
			<p class="blue">En la siguiente tabla se muestra toda la infomación académica que ha suministrado al sistema</p>
			<s:actionerror/>
			<s:if test="tituloList.size() > 0">
				<table class="tabla">
					<tr>
						<th class="tabla">Titulo</th>
						<th class="tabla">Institución</th>
						<th class="tabla">Tipo</th>
						<th class="tabla">Editar</th>
						<th class="tabla">Borrar</th>
					</tr>
					<s:iterator value="tituloList" status="tituloStatus">
						<tr
							class="<s:if test="#tituloStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td class="tabla"><s:property value="formacion" /></td>
							<td class="tabla"><s:property value="institucion" /></td>
							<td class="tabla"><s:property value="tipoformacion" /></td>
							<td class="tabla"><s:url id="editURL" action="editTitulo">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Editar</s:a></td>
							<td class="tabla"><s:url id="deleteURL" action="deleteTitulo">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
		</div>
</div>
</body>
</html>