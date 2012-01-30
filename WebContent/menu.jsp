<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<link href="estilos/facilito.css" rel="stylesheet" type="text/css">

<%@ taglib prefix="s" uri="/struts-tags"%>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Insert title here</title>
</head>
<body class="body">


	<table>



		<tr>
			<s:iterator value="#session.USUARIO_MENUS" status="status">
				<tr class="control">
					<a href="<s:property value="urlMen"/>"><s:property
							value="desMen" /> </a>
				</tr>
			</s:iterator>
		</tr>

		<tr>
			<td class="control"><a href="logueo.jsp"> Cerrar Sesion </a></td>
		</tr>

	</table>


	<br>



</body>
</html>