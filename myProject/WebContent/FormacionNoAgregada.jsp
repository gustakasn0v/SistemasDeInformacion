<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<link rel="stylesheet" type="text/css" href="estilo.css"/>
<html>
<head>
<title>Agregar titulos del profesor</title>
</head>
<body>
<div class="container_3">
	<div class="grid_3"><div class="banner"></div><div class="blue_bar">Bienvenido, <%= session.getAttribute( "username" ) %> <s:url id="url" action="logout"></s:url><s:a href="%{url}">Cerrar sesión</s:a></div></div>
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
		<div class="grid_2">
			<h4>La informacion no fue agregada. Debe rellenar todos los campos</h4>
			<s:url id="url" action="verPlanilla"></s:url>
			<s:a href="%{url}">Volver al menu principal</s:a><br/><br/>
		</div>
	</div>
</body>
</html>