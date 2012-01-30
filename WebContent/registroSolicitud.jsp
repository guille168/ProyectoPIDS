<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>



<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<sj:head jqueryui="true" />
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery.validate.js"></script>
<script type="text/javascript" src="js/jquery.metadata.js"></script>
<link href="css/menuPrincipal.css" type=text/css rel=stylesheet>
<script src="js/menuBar.js" type="text/javascript"></SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function validarBusqueda() {

		alert("pr");
		alert("mero");

		var numSolicitud = document.frmSolicitud.numSolicitud.value;
		alert("segundo");

		String
		cad = "";

		boolean
		todEsCorrecto = true;

		if (numSolicitud.empty()) {
			cad += "Ingrese Numero de Solicitud \n";
			alert(cad);
			todEsCorrecto = false;
		}

		if (todEsCorrecto) {
			alert(cad);
			document.frmSolicitud.submit();
		} else {
			alert(cad);
		}

	}
</script>

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
			<td class="control"><s:form action="registrarSolicitud"
					method="post" enctype="multipart/form-data">

					<table>
						<tr class="titulo">
							<td colspan="2" align="center">Registrar Solicitud</td>
							<!-- 							<td> -->
						

						<!-- 								<form name="frmSolicitud" action="BuscarRequisitos"> -->
						<!-- 									<table> -->
						<tr class="control">
							<td><s:text name="Nro. Solicitud" />
							</td>
							<td><s:textfield name="numSolicitud"
									class="{required:true,maxlength:[25]}" />
							</td>
						</tr>
						<tr class="control">
							<td><s:text name="Tipo Solicitud" />
							</td>
							<td><s:select list="listaTipos" listKey="codTipSol"
									listValue="descripcion" name="tipSol"></s:select>
							<td><s:submit action="BuscarRequisitos"
									value="Buscar Requisitos"></s:submit></td>
						</tr>
						<!-- 									</table> -->
						<!-- 								</form></td> -->
		</tr>
		<tr>
			<th>DATOS UNIVERSITARIOS</th>
		</tr>
<!-- 		<tr> -->
<!-- 			<td> -->
<!-- 				<form> -->
<!-- 					<table> -->
						<tr class="control">
							<td><s:text name="Codigo" />
							</td>
							<td><s:textfield name="codUniv" />
							</td>
							<td><s:submit action="BuscarUniversitario" value="Buscar">
								</s:submit>
							</td>
						</tr>

						<tr class="control">
							<td><s:text name="Nombres" />
							</td>
							<td><s:textfield name="universitario.nomUniv" />
							</td>
						</tr>

						<tr class="control">
							<td><s:text name="Apellidos" />
							</td>
							<td><s:textfield name="universitario.apeUniv" />
							</td>
						</tr>
<!-- 					</table> -->
<!-- 				</form> -->
<!-- 			</td> -->
		<!-- 		</tr> -->
		<tr>
			<th>REQUISITOS SEGUN EL TIPO DE MODALIDAD</th>
		</tr>

		<tr>
			<th><s:text name="Requisitos" />
			</th>

			<th>&nbsp;</th>
		</tr>
		<s:iterator value="listaRequisitos" status="status">
			<tr class="<s:if test="#status.even">even</s:if><s:else>odd</s:else>">
				<td class="nowrap"><s:property value="descripcion" /></td>
			</tr>
		</s:iterator>




	</table>
	<s:submit value="Registrar"></s:submit>
	</s:form>
	</td>


	</tr>


	<tr>
		<!--  aqui va el pie -->
		<td colspan="2" align="center"><jsp:include page="/pie.jsp" /></td>
	</tr>




	</table>


</body>


</html>