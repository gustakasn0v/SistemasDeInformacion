<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<table border="1" cellspacing="1" cellpadding="0" class="boxtbl">
	  <tr>
	      <th></th>
	  	  <th>Descripción del título</th>
		  
	  </tr>
	  <s:iterator value="titulos">
	  <tr>
	      <td><s:checkbox theme="simple" width="5" name="ss"/></td>
	      <td><s:property/></td>
	  </tr>
	  </s:iterator>
	</table>
	

</body>
</html>