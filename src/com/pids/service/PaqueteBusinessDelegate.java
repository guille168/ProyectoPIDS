package com.pids.service;

import com.pids.interfaces.ICategorizacion;
import com.pids.interfaces.IReporteCategorizacion;
import com.pids.interfaces.ISolicitud;
import com.pids.interfaces.ITrabajador;
import com.pids.interfaces.IUniversitario;

public class PaqueteBusinessDelegate {

	private PaqueteBusinessDelegate() {
		// TODO Auto-generated constructor stub
	}

	// creamos un metodo estatico que retorne el servicio LogueoService
	public static ICategorizacion getCategorizacionService() {
		return new SCategorizacion();
	}

	public static ISolicitud getSolicitudService() {
		return new SSolicitud();
	}

	public static IUniversitario getUniversitario() {
		return new SUniversitario();
	}

	public static ITrabajador getTrabajadorService() {
		return new STrabajador();
	}
	
	public static IReporteCategorizacion getReporteCategorizacion(){
		return new SReporteCategorizacion();
	}


}
