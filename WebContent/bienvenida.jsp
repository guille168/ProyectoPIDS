<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!--  hacemos referencia a las librerias de jstl -->
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ taglib prefix="s" uri="/struts-tags"%>

  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">

</head>

<body>

	
	<table>
		
		<tr>
		
		<td colspan="2" align="center"  >
			<!--  aqui va la cabecera -->
			
			<jsp:include page="cabecera.jsp"   />
			 
		</td>
		</tr>

		<tr>
			
			
			<td >
			<!--  aqui va el menu -->
			
			<jsp:include page="menu.jsp"   />
			
			</td>

			<!--  aqui va el cuerpo -->
			<td  >
			
				<table class="control" >
					<tr>
						<td colspan="2" >
						Bienvenido estimado usuario, sus datos son:		
						</td>
					</tr>

					<!--  recuperamos los atributos del usuario logueado
					utilizando EL (Expression Language) -->
					<tr>
						<td>Usuario:</td>
						<td><s:property value="#session.USUARIO_LOGEADO.usuario" /></td>
					</tr>
					<tr>
						<td>Nombre:</td>
						<td><s:property value="#session.USUARIO_LOGEADO.nom_tra"/></td>
					</tr>
					<tr>
						<td>Apellido:</td>
						<td><s:property value="#session.USUARIO_LOGEADO.ape_tra"/></td>
					</tr>			
				</table>			

			</td>
			
			
		</tr>


		<tr>
			<!--  aqui va el pie -->
			<td colspan="2" align="center" >   
			 		<jsp:include page="pie.jsp"   />	
			</td>
		</tr>

		
	</table>
	

</body>
</html>