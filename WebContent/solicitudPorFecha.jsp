<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here - soy jorgito</title>
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
				<table class="control">
					<tr>

						<s:form action="solicitudPorFecha">
							<td><s:label value="Fecha Inicio" /></td>
							<td><sj:datepicker name="fecIni" displayFormat="dd/mm/yy"
									value="today" /></td>
							<td><s:label value="Fecha Fin" /></td>
							<td><sj:datepicker name="fecFin" displayFormat="dd/mm/yy"
									value="today" /></td>
							<td><s:label value="Estado" /></td>

							<td><s:submit action="solicitudPorFecha"></s:submit></td>
						</s:form>
					</tr>

					<tr>
						<th width="150" align="center"><s:text name="Nomb. Univ." />
						</th>
						<th width="150" align="center"><s:text name="Ape. Univ." />
						</th>
						<th width="150" align="center"><s:text name="Nro. Solicitud" />
						</th>
						<th width="150" align="center"><s:text name="Tipo Solicitud" />
						</th>
						<th width="150" align="center"><s:text
								name="Nomb. Trabajador" /></th>
						<th width="150" align="center">&nbsp;</th>
					</tr>
					<s:iterator value="listaCategorizacionMixta" status="status">
						<tr
							class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
							<td class="nowrap" width="150" align="center"><s:property
									value="nom_univ" /></td>
							<td class="nowrap" width="150" align="center"><s:property
									value="ape_univ" /></td>
							<td class="nowrap" width="150" align="center"><s:property
									value="num_solicitud" /></td>
							<td class="nowrap" width="150" align="center"><s:property
									value="tipo_solicitud" /></td>
							<td class="nowrap" width="150" align="center"><s:property
									value="nom_tra" /></td>
						</tr>
					</s:iterator>
				</table>
			</td>


		</tr>


		<tr>
			<!--  aqui va el pie -->
			<td colspan="2" align="center"><jsp:include page="/pie.jsp" />
			</td>
		</tr>




	</table>

</body>
</html>