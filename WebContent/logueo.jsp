<html>

<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s"  uri="/struts-tags" %>

<head>
<title> Esta es mi primera pagina</title>

<link 
	href="estilos/facilito.css" 
	rel="stylesheet" 
	type="text/css" />
	
<script type="text/javascript">
	function f_ingresa(){

		// podemos jugar con java script
		

		
	}

</script>	

</head>

<body>

<font  color="red" size="5" >

<!--  podriamos colocar un titulo utilizando la etiqueta message de la libreria fmt -->
  
</font>

<br> 
<br>

	<!-- dentro de la etiqueta form nosotros definimos campos (controles) 
	En el atributo action de la etiqueta, se indica a quien invocaremos 
	al seleccionar un boton tipo submit
	
	-->

     
	<s:form action="logueo"  method="post"  >   
	
	<table >
		<tr class="etiqueta"  >
			<td colspan="2"  > <img alt="El loguito" src="imagenes/cabecera1.png"  >  </td>
		</tr>
	
		<tr class="etiqueta" align="center" >
			<td> <s:label value="Usuario" />    </td>
			<td> <s:textfield  name="usuario.usuario"  />  </td>
		</tr>
		
		<tr class="etiqueta" align="center" >
			<td  > <s:text name="Clave" />   </td>
			<td> <s:password name="usuario.password"  />  </td>
		</tr>
		<tr align="center">
			<td colspan="2" align="right"  > 
				<s:submit name="boton01" 
						value="Ingresar"  
						action="logueo" /> 
			</td>
		</tr>
		
		<tr>
			<td class="error_general" colspan="2" >
			<!-- podemos visualizar el mensaje de error usando EL -->
			${requestScope.MENSAJE}
			</td>
		
		</tr>
	
	</table>	
	
	</s:form>


</body>


</html>