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
		<div class="grid_4">
	    	<p><img alt="" src="pictures/somosusb.gif"></p>
	    	<p><a href="https://documentosdace.dii.usb.ve/documentosdace/" target="_blank"><img alt="" src="pictures/taquilla.jpg"></a></p>
	    	<p>	<a href="http://www.dace.usb.ve/sites/default/files/pdf/aranceles.pdf" target="_blank"><img alt="" src="pictures/aranceles.jpg"></a></p>
	    	<p>	<a href="http://www.dace.usb.ve/node/31"><img alt="" src="pictures/calendario.jpg"></a></p>
	    	<p>	<a href="http://www.dace.usb.ve/node/29"><img alt="" src="pictures/faq.jpg"></a></p>
	    	<p>	<a href="http://sistema.cenda.usb.ve/reglamentos/categoria/regimen-de-estudios" target="_blank"><img alt="" src="pictures/reglamentos.jpg"></a></p>
	    	<p><a href="http://www.dace.usb.ve/node/30"><img alt="" src="pictures/ayud_mejorar.jpg"></a></p><p><a href="http://www.secretaria.usb.ve/" target="_blank"><img alt="" src="./pictures/secretaria.gif"></a></p>
	    	<p><a href="http://www.secretaria.usb.ve/sites/default/files/documentos/proyectoaportesUSB.pdf" target="_blank"><img alt="" src="pictures/sticker_portal_aportes.jpg"></a></p>
	    </div>
	    
	    <%-- 
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
		--%>
		
		<div class="grid_2">
			<p class="blue">En la siguiente tabla se muestra toda la infomación académica que ha suministrado al sistema</p>
			<s:actionerror/>
			
			<a>Datos Personales</a><br>
			<a>Nombre: <%= session.getAttribute( "nombre" ) %></a><br>
			
			<a>Titulos académicos</a>
			<s:if test="tituloList.size() >= 0">
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
					<tr>
						<th class="tabla">
							<s:url id="url" action="modTitulo"></s:url>
							<s:a href="%{url}">Agregar más títulos académicos</s:a><br/><br/>
						</th>
					</tr>
				</table>
			</s:if>
			
			<a>Materiales de apoyo</a>
			<s:if test="materialApoyoList.size() >=0">
			<div class="content">
			<table class="tabla3">
				<tr class="even">
					<th class="tabla3">Titulo</th>
					<th class="tabla3">Archivo</th>
					<th class="tabla3">Revisor</th>
					<th class="tabla3">Editar</th>
					<th class="tabla3">Borrar</th>
				</tr>
				<s:iterator value="materialApoyoList" status="materialApoyoStatus">
					<tr
						class="<s:if test="#materialStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td class="tabla3"><s:property value="titulo" /></td>
						<td class="tabla3"><s:property value="archivo" /></td>
						<td class="tabla3"><s:property value="revisor" /></td>
						<td class="tabla3"> <s:url id="editURL" action="editMaterialApoyo">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}">Editar</s:a></td>
						<td class="tabla3"><s:url id="deleteURL" action="deleteMaterialApoyo">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
					</tr>
				</s:iterator>
				<tr>
					<th class="tabla3">
						<s:url id="url" action="modMaterial"></s:url>
						<s:a href="%{url}">Agregar más materiales de apoyo</s:a><br/><br/>
					</th>
				</tr>
			</table>
			</div>
		</s:if>
			
			<a>Materias modificadas</a>
			<s:if test="materiaList.size() >=0">
				<div class="content">
				<table class="tabla2">
					<tr class="even">
						<th class="tabla2">Codigo</th>
						<th class="tabla2">Nombre</th>
						<th class="tabla2">Editar</th>
						<th class="tabla2">Borrar</th>
					</tr>
					<s:iterator value="materiaList" status="materiaStatus">
						<tr
							class="<s:if test="#materiaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td class="tabla2"><s:property value="codigo" /></td>
							<td class="tabla2"><s:property value="nombre" /></td>
							<td class="tabla2"><s:url id="editURL" action="editMateria">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Editar</s:a></td>
							<td class="tabla2"><s:url id="deleteURL" action="deleteMateria">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
						</tr>
					</s:iterator>
				</table>
				</div>
			</s:if>
			
			
		</div>

    </div>
</body>
</html>