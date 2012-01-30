
function cargaFacultad(){
	DWRUtil.removeAllOptions("cboFacultad");
	FacultadService.traerFacultades(muestraDataFacultades);
}
function muestraDataFacultades(data){
	DWRUtil.addOptions("cboFacultad","-");
    DWRUtil.addOptions("cboFacultad",data,"intCodFacultad","strDescFacultad");
}

function cargaEscuela(){
	DWRUtil.removeAllOptions("cboEscuela");
	var codFacultad = document.getElementById("cboFacultad").value;
	EscuelaService.traerEscuelas(muestraDataEscuela,codFacultad);
}
function muestraDataEscuela(data){
	DWRUtil.addOptions("cboEscuela","-");
    DWRUtil.addOptions("cboEscuela",data,"intCodEscuela","strDescEscuela");
	document.getElementById("cboFacultad").disabled = false;
}

function cargaCarrera(){
	DWRUtil.removeAllOptions("cboCarrera");
	var codFacultad = document.getElementById("cboFacultad").value;
	var codEscuela = document.getElementById("cboEscuela").value;
	CarreraService.traerCarreras(muestraDataCarreras,codFacultad,codEscuela);
}
function muestraDataCarreras(data){
	DWRUtil.addOptions("cboCarrera","-");
	 DWRUtil.addOptions("cboCarrera", data,"intCodCarrera","strDescCarrera");
}

/*
function cargaModalidad(){
	DWRUtil.removeAllOptions("cboTipoModalidad");
	ModalidadService.CargarModalidades(muestraModalidad);
}
function muestraModalidad(data){
	DWRUtil.addOptions("cboTipoModalidad","-");
	 DWRUtil.addOptions("cboTipoModalidad",data,"codtipomodalidad","descripcion");
}*/

/*function muestraModalidad(data){
	 DWRUtil.addOptions("cboTipoModalidad",  //id comboboc 
			data,          //data
			"codtipomodalidad",  //atributo de values de ComboBox
			"descripcion"); //atributo de descripcion de ComboBox
}*/
