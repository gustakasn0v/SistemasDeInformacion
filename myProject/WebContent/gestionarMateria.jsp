<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<s:head />
<style type="text/css">
@import url(style.css);
</style>
</head>
<body>
<s:form action="saveOrUpdateMateria">
	<s:push value="materia">
		<s:hidden name='id'/>
		<s:textfield name="codigo" label="Codigo" />
		<s:textfield name="nombre" label="Nombre" />
		<s:submit />
	</s:push>
</s:form>

<s:if test="materiaList.size() > 0">
	<div class="content">
	<table class="materiaTable" cellpadding="5px">
		<tr class="even">
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Editar</th>
			<th>Borrar</th>
		</tr>
		<s:iterator value="materiaList" status="materiaStatus">
			<tr
				class="<s:if test="#materiaStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="codigo" /></td>
				<td><s:property value="nombre" /></td>
				<td><s:url id="editURL" action="editMateria">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Editar</s:a></td>
				<td><s:url id="deleteURL" action="deleteMateria">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>