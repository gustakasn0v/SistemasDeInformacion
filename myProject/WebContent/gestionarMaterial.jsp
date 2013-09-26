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
<s:form action="saveOrUpdateMaterialApoyo">
	<s:push value="materialApoyo">
		<s:textfield name="titulo" label="Titulo" />
		<s:textfield name="archivo" label="Archivo" />
		<s:textfield name="revisor" label="Revisor" />
		<s:submit />
	</s:push>
</s:form>

<s:if test="materialApoyoList.size() > 0">
	<div class="content">
	<table class="materialTable" cellpadding="5px">
		<tr class="even">
			<th>Titulo</th>
			<th>Archivo</th>
			<th>Revisor</th>
			<th>Editar</th>
			<th>Borrar</th>
		</tr>
		<s:iterator value="materialApoyoList" status="materialApoyoStatus">
			<tr
				class="<s:if test="#materialStatus.odd == true ">odd</s:if><s:else>even</s:else>">
				<td><s:property value="titulo" /></td>
				<td><s:property value="archivo" /></td>
				<td><s:property value="revisor" /></td>
				<td><s:url id="editURL" action="editMaterialApoyo">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{editURL}">Editar</s:a></td>
				<td><s:url id="deleteURL" action="deleteMaterialApoyo">
					<s:param name="id" value="%{id}"></s:param>
				</s:url> <s:a href="%{deleteURL}">Borrar</s:a></td>
			</tr>
		</s:iterator>
	</table>
	</div>
</s:if>
</body>
</html>