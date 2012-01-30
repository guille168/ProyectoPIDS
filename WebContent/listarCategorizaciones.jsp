<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">

</head>
<body>

	<table>

		<tr>

			<td colspan="2" align="center">
				<!--  aqui va la cabecera --> <jsp:include page="/cabecera.jsp" />

			</td>
		</tr>

		<tr>


			<td>
				<!--  aqui va el menu --> <jsp:include page="/menu.jsp" /></td>

			<!--  aqui va el cuerpo -->
			<td class="control">
				<center>
					<form action="filtrarPorSolicitud">
						
						<s:textfield name="numSolicitud" class="{required:true,maxlength:[25]}" required="true" label="Solicitud"  />

						<s:submit action="filtrarPorSolicitud"></s:submit>
					</form>
					<table align=center class="borderAll">
						<tr>
							<th><s:text name="Codigo" /></th>
							<th><s:text name="Estado" /></th>
							<th><s:text name="Monto" /></th>

							<th>&nbsp;</th>
						</tr>
						<s:iterator value="listaSolicitud" status="status">
							<tr
								class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
								<td class="nowrap"><s:property value="numSolicitud" /></td>
								<td class="nowrap"><s:property value="estado" /></td>
										</tr>
						</s:iterator>
					</table>

				</center></td>


		</tr>


		<tr>
			<!--  aqui va el pie -->
			<td colspan="2" align="center"><jsp:include page="/pie.jsp" />
			</td>
		</tr>




	</table>

</body>
</html>