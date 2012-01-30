



function foco(){
	document.getElementById("txtCodigo").focus();
	
}

function limpiar(){
	document.getElementById("txtCodigo").value="";
	
}


function cargarDatos(){
	//var codigoModalidad = document.getElementById("cboTipoModalidad").value;
	var codigoModalidad =document.getElementById("cboTipoModalidad").value;
	//document.getElementById("txtTotalPagar").value =ModalidadService.Costo(codigoModalidad);
	ModalidadService.Costo(muestraCargaTotal,codigoModalidad);
	
}
function muestraCargaTotal(data){
	document.getElementById("txtTotalPagar").value =data.dblTotal;
	
}





