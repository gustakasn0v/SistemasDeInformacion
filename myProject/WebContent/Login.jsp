<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>


<link rel="stylesheet" type="text/css" href="estilo.css"/>

<html>

<body>

<div id="body-content">
	<div id="banner"></div>
	
	<div id="center">
   	<h4>Bienvenido</h4>
	   	<h5>En el siguiente sistema, el Coordinador docente puede realizar la evaluación correspondiente a
	   	  	las actividades docentes realizadas por los profesores con motivo de renovar su contratración
	   	  	o para su pase de escalafón en la Universidad Simón Bolívar<br/><br/>
			<b>Por favor ingrese su USBID y contraseña.</b></h5>
			<div id="medio">
				<s:actionerror />
				<s:form  action="login.action" method="post" namespace="/">
				    <s:textfield name="username" key="label.username"/>
				    <s:password name="password" key="label.password"/>
				    <s:submit method="execute" key="label.login"/>
				</s:form>
				<s:url id="url" action="accionContrasenia"></s:url>
			    <s:a href="%{url}">¿Olvido su contraseña?</s:a>
			</div> 	
	</div>
</div>
</body>
</html>