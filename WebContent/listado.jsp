<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
Se utiliza la directiva taglib para referenciar a las librerias
de etiquetas. Podemos tener tantas directivas taglib como librerias
de etiquetas queramos referenciar
 -->


<!--  hacemos referencia a las librerias de jstl -->
<%@ taglib   prefix="c"  
			uri="http://java.sun.com/jsp/jstl/core"  %>

<%@ taglib   prefix="fmt"  
			uri="http://java.sun.com/jsp/jstl/fmt"  %>

<!--  hacemos referencia a la librerias de struts2 -->
<%@ taglib prefix="s"  uri="/struts-tags" %>
  
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
			<td class="control" >

			<s:form action="listaClientes" method="post">
					
					Nombre:  <s:textfield name="nombrebusqueda"  /> 
					
					<s:submit  name="boton01" value="Listar" /> 
								

				<table>
				  <tr class="grilla_cabecera" >
				    <th>Codigo</th>
				    <th>Nombre</th>
				    <th>Sueldo</th>
				    <th>Fecha de Nacimiento</th>
				    <th>Imagen1</th>
				    <th>Imagen2</th>
				    <th>Documento</th> 
				    <th>Eliminar</th>
				    <th>Modificar</th>
				    				  </tr>
				  
				  <s:iterator value="clientes">
				  
				  	 <tr class="grilla_campo" >
				  	 
				  		    <td> <s:property value="codigo"/></td>
						    <td> <s:property value="nombre"/></td>
						    <td> <s:property value="sueldo"/> </td>
						    <td> <s:date name="fecnac" format="dd/MM/yy"/> </td>
						    <td>
						    	<img  
						    	 alt="Fotografia del Cliente:) " 
								 src="cargaImagenClienteFoto1?codigo=<s:property value="codigo"/>" 
								 width="100"
								 height="50"/>
						    </td>
						    <td>
						    	<img  
						    	 alt="Fotografia del Cliente:) " 
								 src="cargaImagenClienteFoto2?codigo=<s:property value="codigo"/>" 
								 width="100"
								 height="50"/>
						    </td>
						     <td>
						     <a href="cargaDocumento?codigo=<s:property value="codigo"/>" > document.doc  </a>
						       </td>
						    <td align="center" > 
								E						    
						    </td>
						    <td align="center" >
	
		
						     <s:a action="cargaModificaCliente" >
<s:label>M</s:label>
							      <s:param name="codigobusqueda" > <s:property value="codigo"/></s:param>
							     
						     </s:a>
						    	 
						    </td>
						  </tr>
				  
				  
				  </s:iterator>

<%-- 
				  <c:if test="${requestScope.clientes!=null}"   >
				
					<c:forEach   
						items="${requestScope.clientes}"  
						var="elcli"  >
						
						  <tr class="grilla_campo" >
						    <td> ${elcli.nombre }  </td>
						    <td> ${elcli.sueldo }  </td>
						    <td> ${elcli.fecnac }  </td>
						    <td align="center" > 
								E						    
						    </td>
						    <td align="center" >
								<s:url id="carga" action="cargaModificaCliente"  >
						    		<s:param name="usuario" > ${elcli.usuario} </s:param>
						    	</s:url>	
						     
						    	 <a  href="${carga}" >  M </a>
						    	 
						    </td>
						  </tr>
					
					
					</c:forEach>
				
				</c:if>
	--%>						  
				</table>
				
				<tr  class="control" >
						<td colspan="5" align="right"  >
							<a href="nuevoCliente.jsp" > 
									Nuevo Cliente   
							</a>
						</td>
					
					</tr>
				
				</s:form>

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