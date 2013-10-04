<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="estilo.css"/>
<html>
<head>
<title>Agregar titulos del profesor</title>
</head>
<body>
<div class="container_3">
	<div class="grid_3"><div class="banner"></div><div class="blue_bar">Bienvenido, <%= session.getAttribute( "nombre" ) %> <s:url id="url" action="logout"></s:url><s:a href="%{url}"> Cerrar sesión</s:a></div></div>
<%--  	    <div class="grid_1">
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
		</div> --%>
		<div class="grid_5">
	<h3 class="blue">En esta sección, usted podrá agregar y editar las materias que ha dictado</h3>
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
		
		<div class="center">
		<br/><br/><s:url id="url" action="verPlanilla"></s:url>
		<s:a href="%{url}">Volver a la página principal</s:a><br/><br/>
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