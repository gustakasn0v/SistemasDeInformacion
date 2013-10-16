<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="estilo.css"/>
<html>
<head>
<title>Bienvenida profesor</title>
</head>
<body>

<div class="container_3">
	<div class="grid_3"><div class="banner"></div><div class="blue_bar">Bienvenido, <%= session.getAttribute( "nombre" ) %> <s:url id="url" action="logout"></s:url><s:a href="%{url}">Cerrar sesión</s:a></div></div>		
		<div class="grid_5">
			<s:actionerror/>
			<div class="centerBig">
<%-- 			<a>Datos Personales</a><br>
			<a>Nombre: <%= session.getAttribute( "nombre" ) %></a><br> --%>
			
			<h1>Titulos académicos</h1>
			<p>En la siguiente tabla se muestra toda la infomación académica que ha suministrado al sistema</p>
			<div class="center600">
			<s:if test="tituloList.size() >= 0">
				<table class="tabla">
					<tr>
						<th class="grande">Titulo</th>
						<th class="grande">Institución</th>
						<th class="tabla">Tipo</th>
						<th class="tabla">Editar</th>
						<th class="tabla">Borrar</th>
					</tr>
					<s:iterator value="tituloList" status="tituloStatus">
						<tr class="<s:if test="#tituloStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td class="tabla"><s:property value="formacion" /></td>
							<td class="tabla"><s:property value="institucion" /></td>
							<td class="tabla"><s:property value="tipoformacion" /></td>
							<td class="tabla"><s:url id="editURL" action="editTitulo">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">
							<img src="pictures/editar.png" /></s:a></td>
							<td class="tabla"><s:url id="deleteURL" action="deleteTitulo">
								<s:param name="id" value="%{id}"></s:param>								
							</s:url> <s:a href="%{deleteURL}">
							<img src="pictures/eliminar.jpg" /></s:a></td>
						</tr>
					</s:iterator>
					<tfoot>
					<tr>
						<td colspan="5" class="tabla">
							<s:url id="url" action="modTitulo"></s:url>
							<s:a href="%{url}">Agregar Título</s:a><br/><br/>
						</td>
					</tr>
					</tfoot>
				</table>
			</s:if>
			</div>
			
			<h1>Materiales de apoyo</h1>
			<p>En la siguiente tabla se muestra todos los materiales de apoyo que ha suministrado al sistema</p>
			<div class="center600">
			<s:if test="materialApoyoList.size() >=0">
			<div class="content">
			<table class="tabla">
				<tr class="even">
					<th class="grande">Titulo</th>
					<th class="grande">Archivo</th>
					<th class="tabla">Revisor</th>
					<th class="tabla">Editar</th>
					<th class="tabla">Borrar</th>
				</tr>
				<s:iterator value="materialApoyoList" status="materialApoyoStatus">
					<tr
						class="<s:if test="#materialStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td class="tabla"><s:property value="titulo" /></td>
						<td class="tabla"><s:property value="archivo" /></td>
						<td class="tabla"><s:property value="revisor" /></td>
						<td class="tabla"> <s:url id="editURL" action="editMaterialApoyo">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{editURL}"><img src="pictures/editar.png" /></s:a></td>
						<td class="tabla"><s:url id="deleteURL" action="deleteMaterialApoyo">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> <s:a href="%{deleteURL}"><img src="pictures/eliminar.jpg" /></s:a></td>
					</tr>
				</s:iterator>
					<tfoot>
					<tr>
						<td colspan="5" class="tabla">
							<s:url id="url" action="modMaterial"></s:url>
							<s:a href="%{url}">Agregar Material de Apoyo</s:a><br/><br/>
						</td>
					</tr>
					</tfoot>
			</table>
			</div>
		</s:if>
		</div>
			<h1>Materias modificadas</h1>
			<p>En la siguiente tabla se muestran todas los materias que ha suministrado al sistema</p>
			<div class="center600">
			<s:if test="materiaModificadaList.size() >=0">
				<div class="content">
				<table class="tabla">
					<tr class="even">
						<th class="grande">Codigo</th>
						<th class="grande">Nombre</th>
						<th class="tabla">Editar</th>
						<th class="tabla">Borrar</th>
					</tr>
					<s:iterator value="materiaModificadaList" status="materiaModificadaStatus">
						<tr
							class="<s:if test="#materiaModificadaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td class="tabla"><s:property value="codigo" /></td>
							<td class="tabla"><s:property value="nombre" /></td>
							<td class="tabla"><s:url id="editURL" action="editMateriaModificada">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}"><img src="pictures/editar.png" /></s:a></td>
							<td class="tabla"><s:url id="deleteURL" action="deleteMateriaModificada">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}"><img src="pictures/eliminar.jpg" /></s:a></td>
						</tr>
					</s:iterator>
					<tfoot>
					<tr>
						<td colspan="5" class="tabla">
							<s:url id="url" action="modMateriaModificada"></s:url>
							<s:a href="%{url}">Agregar Materia</s:a><br/><br/>
						</td>
					</tr>
					</tfoot>
				</table>
				</div>
			</s:if>
			
			<h1>Materias dictadas</h1>
			<p>En la siguiente tabla se muestran todas los materias dictadas provenientes de DACE</p>
			<div class="center600">
			<s:if test="materiaDictadaList.size() >=0">
				<div class="content">
				<table class="tabla">
					<tr class="even">
						<th class="grande">Codigo</th>
             			<th class="grande">Trimestre</th>
            			<th class="tabla">1</th> 
						<th class="tabla">2</th>
						<th class="tabla">3</th>
						<th class="tabla">4</th>
						<th class="tabla">5</th>
						<th class="tabla">Retirados</th>
					</tr>
					<s:iterator value="materiaDictadaList" status="materiaDictadaStatus">
						<tr
							class="<s:if test="#materiaDictadaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td class="tabla"><s:property value="codigoMateria" /></td>
							<td class="tabla"><s:property value="trimestre" /></td>
							<td class="tabla"><s:property value="cantidadUnos" /></td>
							<td class="tabla"><s:property value="cantidadDos" /></td>
							<td class="tabla"><s:property value="cantidadTres" /></td>
							<td class="tabla"><s:property value="cantidadCuatros" /></td>
							<td class="tabla"><s:property value="cantidadCincos" /></td>
							<td class="tabla"><s:property value="cantidadRetirados" /></td>
						</tr>
					</s:iterator>
				</table>
				</div>
			</s:if>
			
		</div>
		
		 	<h1>Tutorias</h1>
			<p>En la siguiente tabla se muestran todas las tutorias provenientes de CCT</p>
			<div class="center600">
			<s:if test="tutoriaList.size() >=0">
				<div class="content">
				<table class="tabla">
					<tr class="even">
						<th class="grande">Título</th>
						<th class="grande">Tipo</th>
						<th class="tabla">Nombre Estudiante</th>
					</tr>
					<s:iterator value="tutoriaList" status="tutoriaStatus">
						<tr
							class="<s:if test="#tutoriaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
							<td class="tabla"><s:property value="titulo" /></td>
							<td class="tabla"><s:property value="tipoTutoria" /></td>
							<td class="tabla"><s:property value="nombreEstudiante" /></td>
						</tr>
					</s:iterator>
				</table>
				</div>
			</s:if>
			
		</div>
		
		</div>	
		</div>
		<div class="push_4">
			<div class="grid_4">
	    	<p><img alt="" src="pictures/somosusb.gif"></p>
	    	<p><a href="https://documentosdace.dii.usb.ve/documentosdace/" target="_blank"><img alt="" src="pictures/taquilla.jpg"></a></p>
	    	<p><a href="http://www.dace.usb.ve/sites/default/files/pdf/aranceles.pdf" target="_blank"><img alt="" src="pictures/aranceles.jpg"></a></p>
	    	<p><a href="http://www.dace.usb.ve/node/31"><img alt="" src="pictures/calendario.jpg"></a></p>
	    	<p><a href="http://www.dace.usb.ve/node/29"><img alt="" src="pictures/faq.jpg"></a></p>
	    	<p><a href="http://sistema.cenda.usb.ve/reglamentos/categoria/regimen-de-estudios" target="_blank"><img alt="" src="pictures/reglamentos.jpg"></a></p>
	    	<p><a href="http://www.dace.usb.ve/node/30"><img alt="" src="pictures/ayud_mejorar.jpg"></a></p><p><a href="http://www.secretaria.usb.ve/" target="_blank"><img alt="" src="./pictures/secretaria.gif"></a></p>
	    	<p><a href="http://www.secretaria.usb.ve/sites/default/files/documentos/proyectoaportesUSB.pdf" target="_blank"><img alt="" src="pictures/sticker_portal_aportes.jpg"></a></p>
	    </div>
	    </div>
    </div>
</body>
</html>