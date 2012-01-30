<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here - G</title>
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
			<td class="control"><s:form action="registraCategorizacion"
					method="post" enctype="multipart/form-data">

					<table>
						<tr class="titulo">
							<td colspan="2" align="center">Actualiza Solicitud</td>
						</tr>
						<tr class="control">
							<td><s:text name="Nro. Solicitud" /></td>
							<td><s:textfield name="numSolicitud" required="true"/></td>
							<td><s:submit action="filtrarSolicitud" /></td>
						</tr>
						<tr>
							<th><s:text name="Solicitud"  />
							</th>
							<th><s:text name="Fecha"   />
							</th>
							<th><s:text name="Estado" />
							</th>
							<th><s:text name="Seleccion" />
							</th>

							<th>&nbsp;</th>
						</tr>
						<s:iterator value="listaSolicitud" status="status">
							<tr
								class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
								<td class="nowrap"><s:property value="numSolicitud" /></td>
								<td class="nowrap"><s:property value="fecha" /></td>
								<td class="nowrap"><s:property value="estado" /></td>
								<td class="nowrap"><s:url id="filtrarSolicitud" action="filtrarSolicitud">
									<s:param name="numSolicitud" value="numSolicitud"></s:param>
									</s:url><s:a href="%{filtrarSolicitud}" > Ver Detalle </s:a>
										
								</td>
													
							</tr>
						</s:iterator>

						<tr class="control">
							<td><s:text name="Codigo" /></td>
							<td><s:textfield name="solicitud.universitario.codUniv" class="{required:true,maxlength:[25]}"/>
							</td>
						</tr>
						<tr class="control">
							<td><s:text name="Nombres" /></td>
							<td><s:textfield name="solicitud.universitario.nomUniv" class="{required:true,maxlength:[25]}" />
							</td>
							<td><s:text name="Apellidos" /></td>
							<td><s:textfield name="solicitud.universitario.apeUniv" class="{required:true,maxlength:[25]}"/>
							</td>

						</tr>
						<tr class="control">
							<td><s:text name="Cantidad a Entregar" /></td>
							<td><s:textfield name="categorizacionB.montoEntrega" /></td>
							<!-- 							<td> -->
							<!-- 								<div align="left"> -->
							<%-- 									<sj:datepicker name="cliente.fecnac" displayFormat="dd/mm/yy" --%>
							<!-- 										changeYear="true" /> -->
							<!-- 								</div></td> -->
						</tr>
						<tr class="control">
							<td>Estado:</td>
							<td><s:radio
									list="#{'APROBADO':'APROBADO','RECHAZADO':'RECHAZADO'}"
									name="categorizacionB.estado"></s:radio>
							</td>
						</tr>
						<tr class="control">
							<td>Descrpcion del Otorgamiento:</td>
							<td><s:textarea name="categorizacionB.descripcion" class="{required:true,maxlength:[25]}"/></td>
						</tr>
						<tr class="control">
							<td align="right"><input type="submit" name="boton01"
								value="Actualizar"></td>
						</tr>
					</table>

				</s:form></td>


		</tr>


		<tr>
			<!--  aqui va el pie -->
			<td colspan="2" align="center"><jsp:include page="/pie.jsp" />
			</td>
		</tr>




	</table>


</body>


</html>